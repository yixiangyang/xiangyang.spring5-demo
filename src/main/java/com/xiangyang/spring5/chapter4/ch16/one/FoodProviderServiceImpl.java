package com.xiangyang.spring5.chapter4.ch16.one;

import com.xiangyang.spring5.chapter4.ch16.Food;
import com.xiangyang.spring5.chapter4.ch16.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yixiangyang
 * @Date 2022/2/18 16:07
 */
public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));
        return lunchSet;
    }
}
