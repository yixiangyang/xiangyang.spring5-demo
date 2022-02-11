package com.xiangyang.spring5.chapter4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

/**
 * 直接访问 FactoryBean 4.10章节
 * @Author yixiangyang
 * @Date 2022/2/11 15:50
 */
public class AccessingDactoryBeans {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context2-xml.xml");
        ctx.refresh();
        ctx.getBean("shaDigest",MessageDigest.class);
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
        try {
            MessageDigest shaDigester = factoryBean.getObject();
            System.out.println(shaDigester.digest("hello word".getBytes()));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        ctx.close();
    }
}
