package com.xiangyang.spring5.chapter4.ch15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 15:44
 */
public class JavaConfigExampleTwo {

    public static void main(String[] args) {
//        two 测试
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppconfigTwo.class);
        //three 测试
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigThree.class);
        MessageRenderer renderer= ctx.getBean("messageRenderer",MessageRenderer.class);
        renderer.render();
    }
}
