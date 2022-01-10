package com.xiangyang.spring5.chapter4;

import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @Author yixiangyang
 * @Date 2022/1/9 7:06 下午
 */
@Setter
@ToString
public class SingerWithJSR250 {
    private static final String DEFAULT_Name = "eric clapton";

    private String name;

    private Integer age = Integer.MIN_VALUE;
    @PostConstruct
    public void init(){
        System.out.println("Initializing bean");
        if(Objects.isNull(name)){
            System.out.println("using defaut name");
            name = DEFAULT_Name;
        }
        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("" +
                    "you must set the age property of any beans");
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();;
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        getBean("singeOne",ctx);
        getBean("singeTwo",ctx);
        ctx.close();
    }

    public static SingerWithJSR250 getBean(String beanName, ApplicationContext ctx){
        try {
            SingerWithJSR250 bean = (SingerWithJSR250) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        }catch (Exception e){
            System.out.println("an error"+e.getMessage());
            return null;
        }
    }
}
