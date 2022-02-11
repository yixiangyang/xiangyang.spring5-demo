package com.xiangyang.spring5.chapter4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 4.11 章 使用factory-bean 和 factory-method属性
 * @Author yixiangyang
 * @Date 2022/2/11 16:53
 */
public class MessageDigestFactory {

    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }
}
