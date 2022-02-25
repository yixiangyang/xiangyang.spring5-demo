package com.xiangyang.spring5.chapter5.ch5.ch4;

import com.xiangyang.spring5.chapter5.ch4.ch6.Singer;

/**
 * @Author yixiangyang
 * @Date 2022/2/25 17:02
 */
public class GoodGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Who says I  can't be free" +
                "from all of the things that i used to be");
    }
}
