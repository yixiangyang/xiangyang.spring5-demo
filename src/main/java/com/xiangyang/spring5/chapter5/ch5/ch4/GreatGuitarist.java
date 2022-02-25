package com.xiangyang.spring5.chapter5.ch5.ch4;

import com.xiangyang.spring5.chapter5.ch4.ch6.Singer;

/**
 * @Author yixiangyang
 * @Date 2022/2/25 17:04
 */
public class GreatGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("I shot the sheriff," +
                "but i did not shoot the deputy");
    }
}
