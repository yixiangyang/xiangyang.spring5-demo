package com.xiangyang.spring5.chapter2.decoupled;

/**
 * @Author yixiangyang
 * @Date 2022/1/8 9:03 下午
 */
public class HelloWorldDecopledWithFactory {
    public static void main(String[] args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();;
        mr.setMessageProvider(mp);
        mr.render();
    }
}
