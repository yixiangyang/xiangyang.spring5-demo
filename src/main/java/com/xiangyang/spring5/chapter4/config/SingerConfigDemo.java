package com.xiangyang.spring5.chapter4.config;

import com.xiangyang.spring5.chapter4.Singer;
import com.xiangyang.spring5.chapter4.SingerWithInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author yixiangyang
 * @Date 2022/1/10 21:32
 */
public class SingerConfigDemo {
    @Configuration
    static class SingerConfig{
        @Bean(initMethod = "init")
        @Lazy
        Singer singerOne(){
            Singer singerOne = new Singer();
            singerOne.setName("John Mayer");
            singerOne.setAge(39);
            return singerOne;
        }
        @Lazy
        @Bean(initMethod = "init")
        Singer singerTwo(){
            Singer singerTwo = new Singer();
            singerTwo.setAge(15);
            return singerTwo;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);
        Singer.getBean("singerOne",ctx);
        Singer.getBean("singerTwo",ctx);
    }

}
