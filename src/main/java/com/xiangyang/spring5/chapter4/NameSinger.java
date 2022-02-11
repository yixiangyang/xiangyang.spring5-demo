package com.xiangyang.spring5.chapter4;

import org.springframework.beans.factory.BeanNameAware;

/**
 *  使用beanNameAware 接口 ，获取自己的名称可以实现beanNameAware接口
 *
 * @Author yixiangyang
 * @Date 2022/2/11 13:52
 */
public class NameSinger implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String beanName) {
        this.name = beanName;
    }

    public void sing(){
        System.out.println("Singer "+name+"-sing()");
    }
}
