package com.xiangyang.spring5.chapter2.annotated;

import com.xiangyang.spring5.chapter2.decoupled.HelloWordMesageProvider;
import com.xiangyang.spring5.chapter2.decoupled.MessageProvider;
import com.xiangyang.spring5.chapter2.decoupled.MessageRenderer;
import com.xiangyang.spring5.chapter2.decoupled.StandardOutMessageRender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yixiangyang
 * @Date 2022/1/8 9:13 下午
 */
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public MessageProvider provider(){
        return new HelloWordMesageProvider();
    }

    @Bean
    public MessageRenderer renderer(){
        StandardOutMessageRender standardOutMessageRender =new StandardOutMessageRender();
        standardOutMessageRender.setMessageProvider(provider());
        return standardOutMessageRender;
    }

}
