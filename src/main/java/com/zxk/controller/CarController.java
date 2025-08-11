package com.zxk.controller;

import com.zxk.entity.Car;
import com.zxk.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class CarController {

    @Autowired
    private CarMapper carMapper;

    @ResponseBody
    @RequestMapping("/caradd.do")
    public Integer caradd(@RequestBody Car car ){
        Integer integer=carMapper.insert(car);
        return integer;
    }
}
