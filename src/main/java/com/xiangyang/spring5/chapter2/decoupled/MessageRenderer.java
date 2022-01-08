package com.xiangyang.spring5.chapter2.decoupled;

/**
 * @Author yixiangyang
 * @Date 2022/1/8 8:40 下午
 */
public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
