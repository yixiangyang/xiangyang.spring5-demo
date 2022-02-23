package com.xiangyang.spring5.chapter5.ch4.ch6;


/**
 * @Author yixiangyang
 * @Date 2022/2/22 16:16
 */
public class Guitarist  implements Singer{

    private String lyric = "you are gonna live ";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
