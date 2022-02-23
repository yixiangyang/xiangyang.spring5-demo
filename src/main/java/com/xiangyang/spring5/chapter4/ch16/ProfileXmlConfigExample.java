package com.xiangyang.spring5.chapter4.ch16;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 16:14
 */
public class ProfileXmlConfigExample {
    //JVM 参数  -Dspring.profiles.active=""
    public static void main(String[] args) throws IOException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:spring/*-config.xml");
        ctx.load("classpath:spring/*-config.xml");
        ctx.refresh();
//        System.out.println(ctx.getResource("classpath:spring/highschool-config.xml").getURL());;
        FoodProviderService foodProviderService = ctx.getBean("foodProviderService",FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food:"+food.getName());
        }
        ctx.close();
    }
}
