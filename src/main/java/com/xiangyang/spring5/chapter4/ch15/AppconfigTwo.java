package com.xiangyang.spring5.chapter4.ch15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 15:41
 */
@Configuration
@ComponentScan(basePackages = "com.xiangyang.spring5.chapter4.ch15")
public class AppconfigTwo {
    @Autowired
    MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandarOutMessageRenderer();
        renderer.setMessageProvider(provider);
        return renderer;
    }
}
