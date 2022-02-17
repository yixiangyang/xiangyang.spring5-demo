package com.xiangyang.spring5.chapter4.ch15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author yixiangyang
 * @Date 2022/2/17 17:41
 */
public class JavaConfigXmlExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/app-context4-xml.xml");
        MessageRenderer renderer = ctx.getBean("messageRenderer",MessageRenderer.class);
        renderer.render();
    }
}
