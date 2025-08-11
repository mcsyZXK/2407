package com.zxk.mapper;

import com.zxk.entity.Car;

public interface CarMapper {
    Car[] findByXinxi(String xinxi);
    Integer insert(Car car);
    Car findByCheNum(String chenum);
    Car[] findAll();
    Car[] findAllnzl();
}
