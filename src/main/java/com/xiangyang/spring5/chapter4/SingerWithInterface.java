package com.xiangyang.spring5.chapter4;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Objects;

/**
 * @Author yixiangyang
 * @Date 2022/1/9 6:45 下午
 */
@Setter
@ToString
public class SingerWithInterface implements InitializingBean {

    private static final String DEFAULT_Name = "eric clapton";

    private String name;

    private Integer age = Integer.MIN_VALUE;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean SingerWithInterface");
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
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        getBean("singeOneWith",ctx);
        getBean("singeTwoWith",ctx);
        ctx.close();
    }

    public static SingerWithInterface getBean(String beanName, ApplicationContext ctx){
        try {
            SingerWithInterface bean = (SingerWithInterface) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        }catch (Exception e){
            System.out.println("an error"+e.getMessage());
            return null;
        }
    }
}
