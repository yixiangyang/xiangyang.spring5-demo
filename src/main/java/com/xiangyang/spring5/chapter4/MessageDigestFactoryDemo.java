package com.xiangyang.spring5.chapter4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 4.11 章测试 使用factory-bean 和factory-method属性
 * @Author yixiangyang
 * @Date 2022/2/11 17:02
 */
public class MessageDigestFactoryDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context3-xml.xml");
        ctx.refresh();
        MessageDigester digester = ctx.getBean("digester",MessageDigester.class);
        digester.digest("hello world");
        ctx.close();
    }
}
