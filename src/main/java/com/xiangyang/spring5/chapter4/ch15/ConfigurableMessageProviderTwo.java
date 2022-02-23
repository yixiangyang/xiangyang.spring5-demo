package com.xiangyang.spring5.chapter4.ch15;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 15:37
 */
@Service("provider")
public class ConfigurableMessageProviderTwo implements MessageProvider{

    private String message;

    public ConfigurableMessageProviderTwo(@Value("Love on the weekend") String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
