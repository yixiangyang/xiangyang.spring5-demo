package com.xiangyang.spring5.chapter2.decoupled;

/**
 * @Author yixiangyang
 * @Date 2022/1/8 8:46 下午
 */
public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRender();
        HelloWordMesageProvider mp = new HelloWordMesageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
