package com.xiangyang.spring5.chapter5.ch4.ch8;

import java.util.Random;

/**
 * @Author yixiangyang
 * @Date 2022/2/25 15:12
 */
public class KeyGenerator {
    protected static final long WEAK_KEY = 0xFFFFFF0000000L;

    protected static final long STRONG_KEY = 0xACDF03F590AE56L;

    private Random rand = new Random();

    public long getKey(){
        int x = rand.nextInt(3);
        if(x==1){
            return WEAK_KEY;
        }
        return STRONG_KEY;
    }
}
