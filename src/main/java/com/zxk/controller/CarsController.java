package com.zxk.controller;

import com.zxk.entity.Car;
import com.zxk.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarsController {
    @Autowired
    private CarMapper carMapper;
    @RequestMapping("/cars.do")
    @ResponseBody
    public Car[] showCar(){
        return carMapper.findAllnzl();
    }
}
