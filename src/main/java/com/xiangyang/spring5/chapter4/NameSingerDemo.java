package com.xiangyang.spring5.chapter4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 从applicationContext中检索Singer实例 然后调用sing()方法
 * @Author yixiangyang
 * @Date 2022/2/11 14:22
 */
public class NameSingerDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();;
        ctx.load("classpath:spring/app-context1-xml.xml");
        ctx.refresh();
        NameSinger bean = (NameSinger) ctx.getBean("johnMayer");
        bean.sing();
        ctx.close();
    }
}
