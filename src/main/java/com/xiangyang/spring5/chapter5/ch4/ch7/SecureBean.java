package com.xiangyang.spring5.chapter5.ch4.ch7;

/**
 * 前置通知 保护方法访问
 * @Author yixiangyang
 * @Date 2022/2/23 14:14
 */
public class SecureBean {
    public void writeSecureMessage(){
        System.out.println("envery time i learn something new,"+
                "it pushes some old stuff out of my brain");
    }
}
