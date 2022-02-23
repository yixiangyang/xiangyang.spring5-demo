package com.xiangyang.spring5.chapter4.ch15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 15:22
 */
@Configuration
@PropertySource(value = "classpath:message.properties")
public class AppConfigOne {
    @Autowired
    Environment env;

    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messagerenderer")
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandarOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
