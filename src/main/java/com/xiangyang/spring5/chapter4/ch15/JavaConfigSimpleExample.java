package com.xiangyang.spring5.chapter4.ch15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 15:13
 */
public class JavaConfigSimpleExample {

    @Configuration
    static class AppConfigOne{
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

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigOne.class);
        MessageRenderer renderer = ctx.getBean("messageRenderer",MessageRenderer.class);
        renderer.render();
    }
}
