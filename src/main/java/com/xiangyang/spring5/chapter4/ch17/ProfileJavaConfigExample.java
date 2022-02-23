package com.xiangyang.spring5.chapter4.ch17;

import com.xiangyang.spring5.chapter4.ch16.Food;
import com.xiangyang.spring5.chapter4.ch16.FoodProviderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

/**
 * @Author yixiangyang
 * @Date 2022/2/21 15:48
 */
public class ProfileJavaConfigExample {
    /**
     * 执行时 需要在vm options中添加参数 -Dspring.profiles.active=highschool
     * @param args
     */
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(KindergartenConfig.class,HighschoolConfig.class);
        FoodProviderService foodProviderService = ctx.getBean("foodProviderService",FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println(food.getName());
        }
    }
}
