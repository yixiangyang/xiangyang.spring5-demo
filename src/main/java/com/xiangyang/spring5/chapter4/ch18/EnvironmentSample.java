package com.xiangyang.spring5.chapter4.ch18;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yixiangyang
 * @Date 2022/2/21 16:12
 */
public class EnvironmentSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        Map<String,Object> appMap = new HashMap<>();
        appMap.put("user.home","application_home");
        propertySources.addLast(new MapPropertySource("prospring5 MAP",appMap));
        System.out.println("user.home:"+System.getProperty("user.home"));
        System.out.println("JAVA_HOME"+ System.getenv("JAVA_HOME"));

        System.out.println("user.home:"+env.getProperty("user.home"));
        System.out.println("JAVA_HOME"+ env.getProperty("JAVA_HOME"));
        System.out.println(env.getPropertySources().get("prospring5 MAP").getProperty("user.home"));

        ctx.close();
    }
}
