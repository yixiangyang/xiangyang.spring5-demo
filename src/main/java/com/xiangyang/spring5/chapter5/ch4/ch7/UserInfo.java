package com.xiangyang.spring5.chapter5.ch4.ch7;

/**
 * @Author yixiangyang
 * @Date 2022/2/23 14:16
 */
public class UserInfo {
    private String userName;

    private String password;

    public UserInfo(){

    }
    public UserInfo(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public String getUserName(){
        return userName;
    }
}
