package com.xiangyang.spring5.chapter4.ch15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 15:10
 */
public class JavaConfigExampleOne {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRenderer renderer = ctx.getBean("messageRenderer",MessageRenderer.class);
        renderer.render();
    }
}
