package com.xiangyang.spring5.chapter4;

import java.security.MessageDigest;

/**
 * @Author yixiangyang
 * @Date 2022/2/11 15:02
 */
public class MessageDigester {

    private MessageDigest digest1;

    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1){
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2){
        this.digest2 = digest2;
    }

    public void digest(String msg){
        System.out.println( "Using digest1");
        digest(msg,digest1);

        System.out.println("using digest2");
        digest(msg,digest2);
    }

    private void digest(String msg,MessageDigest digest){
        System.out.println("using alogrithm: "+ digest.getAlgorithm());
        digest.reset();

        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(out);
    }
}
