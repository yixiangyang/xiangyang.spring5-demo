package com.xiangyang.spring5.chapter5.ch4.ch9;

/**
 * @Author yixiangyang
 * @Date 2022/2/25 15:26
 */
public class WorkerBean {
    public void doSomeWork(int noOfTimes){
        for (int x = 0;x<noOfTimes;x++){
            work();
        }
    }

    private void work(){
        System.out.println("-----");
    }
}
