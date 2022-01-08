package com.xiangyang.spring5.chapter2.annotated;

import com.xiangyang.spring5.chapter2.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yixiangyang
 * @Date 2022/1/8 9:16 下午
 */
public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                HelloWorldConfiguration.class
        );
        MessageRenderer mr = ctx.getBean("renderer",MessageRenderer.class);
        mr.render();
    }
}
