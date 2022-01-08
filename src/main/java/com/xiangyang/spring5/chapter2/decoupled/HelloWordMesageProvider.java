package com.xiangyang.spring5.chapter2.decoupled;

/**
 * @Author yixiangyang
 * @Date 2022/1/8 8:43 下午
 */
public class HelloWordMesageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello Wold!";
    }
}
