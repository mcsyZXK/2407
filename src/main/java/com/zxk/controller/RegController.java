package com.zxk.controller;

import com.zxk.entity.JsonResult;
import com.zxk.entity.User;
import com.zxk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/reg.do")
    @ResponseBody
    public JsonResult reg(@RequestBody User user){
        JsonResult jsonResult=new JsonResult();
        String email=user.getEmail();
        User user1=userMapper.findByEmail(email);
        System.out.println(user1);
        System.out.println(user);
        if(user.getEmail().equals("")||user.getPassword().equals("")){
            jsonResult.setState(0);
            jsonResult.setMessage("邮箱为空或密码为空");
            return jsonResult;
        }
        else if(user1==null){
            Integer integer=userMapper.insert(user);
            if(integer==1){
                jsonResult.setState(1);
                jsonResult.setMessage("注册成功");
                System.out.println("成功");
            }else {
                jsonResult.setState(3);
                jsonResult.setMessage("意外错误");
                System.out.println("意外错误");
            }
            return jsonResult;
        }else {
            jsonResult.setState(0);
            jsonResult.setMessage("邮箱已注册");
            System.out.println("已注册");
            return jsonResult;
        }
    }
}
