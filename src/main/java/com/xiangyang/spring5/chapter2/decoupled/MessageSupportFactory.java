package com.xiangyang.spring5.chapter2.decoupled;

import java.util.Properties;

/**
 * 创建一个工厂类，从属性文件中读取实现类的名称，
 * 并代表应用程序对它们进行实例化
 * @Author yixiangyang
 * @Date 2022/1/8 8:51 下午
 */
public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private Properties props;
    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory(){
        props = new Properties();
        try {
            props.load(this.getClass().getResourceAsStream("/msf.properties"));
            String rendererClass = props.getProperty("renderer.class");
            String providerClass= props.getProperty("provider.class");
            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageRenderer getMessageRenderer(){
        return renderer;
    }

    public MessageProvider getMessageProvider(){
        return provider;
    }
}

