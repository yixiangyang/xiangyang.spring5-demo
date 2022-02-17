package com.xiangyang.spring5.chapter4.ch15;

/**
 * @Author yixiangyang
 * @Date 2022/2/17 17:24
 */
public class ConfigurableMessageProvider implements MessageProvider{
    private String message = "Default message";

    public ConfigurableMessageProvider() {
        System.out.println("--> provider");
    }

    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
