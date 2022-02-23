package com.xiangyang.spring5.chapter5.ch4.ch7;

/**
 * @Author yixiangyang
 * @Date 2022/2/23 14:19
 */
public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal =
            new ThreadLocal<>();

    public void login(String userName,String password){
        threadLocal.set(new UserInfo(userName,password));
    }

    public void logout(){
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser(){
        return threadLocal.get();
    }
}
