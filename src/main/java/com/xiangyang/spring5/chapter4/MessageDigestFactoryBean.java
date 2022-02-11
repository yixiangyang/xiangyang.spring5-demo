package com.xiangyang.spring5.chapter4;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

/**
 * @Author yixiangyang
 * @Date 2022/2/11 15:10
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
    private String algorithmName = "MD5";
    private MessageDigest messageDigest = null;
    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }
    public boolean isSingleton(){
        return true;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("返回指定算法实现的对象："+ algorithmName);
        messageDigest = messageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }
}
