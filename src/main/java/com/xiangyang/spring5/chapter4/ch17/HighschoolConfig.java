package com.xiangyang.spring5.chapter4.ch17;

import com.xiangyang.spring5.chapter4.ch16.FoodProviderService;
import com.xiangyang.spring5.chapter4.ch16.two.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author yixiangyang
 * @Date 2022/2/21 15:47
 */
@Configuration
@Profile("highschool")
public class HighschoolConfig {
    @Bean()
    public FoodProviderService foodProviderService(){
        System.out.println("这个是HighschoolConfig");
        return new FoodProviderServiceImpl();
    }
}
