package com.xiangyang.spring5.chapter4;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

/**
 * @Author yixiangyang
 * @Date 2022/1/12 16:09
 */
@Component
public class DestructiveBeanWithJSR250 {
    private File file;

    private String filePath;

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    @PostConstruct
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

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("销毁bean");
        if(!file.delete()){
            System.err.println("error:filed to deleted file.");
        }
        System.out.println("file exits："+file.exists());
    }

    public static void main(String[] args) {
        DestructiveBeanWithJSR250 destructiveBeanWithJSR250 = new DestructiveBeanWithJSR250();
        destructiveBeanWithJSR250.setFilePath("/Users/yixiangyang/work/xiangyangLearn/xiangyang.spring5-demo/src/main/resources/test1.txt");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.registerBean("destructiveBean",destructiveBeanWithJSR250.getClass(),destructiveBeanWithJSR250);
        ctx.refresh();

    }
}
