package com.xiangyang.spring5.chapter4.ch15;

/**
 * @Author yixiangyang
 * @Date 2022/2/17 17:29
 */
public class StandarOutMessageRenderer implements MessageRenderer{

    private MessageProvider messageProvider;

    public StandarOutMessageRenderer(){
        System.out.println("--> StandarOutMessageRenderer:constructor called");
    }

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("you must set the property messageProvider of class");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        System.out.println("--》" +
                "StandarOutMessageRenderer seting the provider");
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
