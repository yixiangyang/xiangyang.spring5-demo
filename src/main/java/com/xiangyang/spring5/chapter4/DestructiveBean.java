package com.xiangyang.spring5.chapter4;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * 销毁bean
 * @Author yixiangyang
 * @Date 2022/1/11 14:18
 */
public class DestructiveBean implements InitializingBean {
    private File file;

    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        if(StringUtils.isBlank(filePath)){
            //必须指定filePath属性
            throw new IllegalArgumentException("you must specify " +
                    "the filePath property of"+ DestructiveBean.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("初始file exists："+ this.file.exists());
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public void destroy(){
        System.out.println("销毁bean");
        if(!file.delete()){
            System.err.println("error:filed to deleted file.");
        }
        System.out.println("file exits："+file.exists());
    }

    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir");
        System.out.println(rootPath+"/src/main/resources/test1.txt");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-destruct-xml.xml");
        ctx.refresh();
        DestructiveBean destructiveBean = (DestructiveBean)ctx.getBean("destructiveBean");
        System.out.println("calling destruct");
        destructiveBean.destroy();
        System.out.println("calling destruct");
    }
}
