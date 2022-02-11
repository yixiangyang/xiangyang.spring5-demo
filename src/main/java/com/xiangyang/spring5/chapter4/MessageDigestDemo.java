package com.xiangyang.spring5.chapter4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Author yixiangyang
 * @Date 2022/2/11 15:27
 */
public class MessageDigestDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();;
        ctx.load("classpath:spring/app-context2-xml.xml");
        ctx.refresh();
        MessageDigester digester = ctx.getBean("digester",MessageDigester.class);
        digester.digest("hello world!");
        ctx.close();
    }
}
