package com.xiangyang.spring5.chapter4.ch15;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 15:07
 */
@Configuration
public class AppConfig {

    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandarOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
