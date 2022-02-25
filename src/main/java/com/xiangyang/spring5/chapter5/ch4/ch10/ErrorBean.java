package com.xiangyang.spring5.chapter5.ch4.ch10;

/**
 * @Author yixiangyang
 * @Date 2022/2/25 16:01
 */
public class ErrorBean {
    public void errorProneMethod() throws Exception{
        throw new Exception("generic exception");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException{
        throw new IllegalThreadStateException("illegalArgument exception");
    }
}
