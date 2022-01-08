package com.xiangyang.spring5.chapter2.decoupled;

import java.util.Objects;

/**
 * @Author yixiangyang
 * @Date 2022/1/8 8:43 下午
 */
public class StandardOutMessageRender implements MessageRenderer{
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(Objects.isNull(messageProvider)){
            throw new RuntimeException("you must set the property messageProvider of class:"+
                    StandardOutMessageRender.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
