package com.xiangyang.spring5.chapter4;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * @Author yixiangyang
 * @Date 2022/1/12 15:52
 */
public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {

    private File file;

    private String filePath;

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    /**
     * 销毁bean
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("销毁bean");
        if(!file.delete()){
            System.err.println("error:filed to deleted file.");
        }
        System.out.println("file exits："+file.exists());
    }

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

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-destruct-interface-xml.xml");
        ctx.refresh();
        DestructiveBeanWithInterface destructiveBean = (DestructiveBeanWithInterface)ctx.getBean("destructiveBean");
        System.out.println("calling destruct");
        ctx.destroy();
        System.out.println("calling destruct");
    }
}
