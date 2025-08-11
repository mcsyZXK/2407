package com.zxk.controller;

import com.zxk.entity.JsonResult;
import com.zxk.entity.User;
import com.zxk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult reg(@RequestBody User user, HttpSession httpSession){
        JsonResult jsonResult=new JsonResult();
        String email=user.getEmail();
        User user1=userMapper.findByEmail(email);
        if(email.equals("root@qq.com")&&user.getPassword().equals("1")){
            jsonResult.setState(2);
            User user2=new User();
            user2.setEmail("root@qq.com");
            user2.setPassword("1");
            user2.setUsername("admin");
            httpSession.setAttribute("user",user2);
            return jsonResult;
        }
        else if(user1==null){
            jsonResult.setState(0);
            jsonResult.setMessage("账号错误");
            return jsonResult;
        }else if(user.getPassword() == null ? user1.getPassword() != null : !user.getPassword().equals(user1.getPassword())){
            jsonResult.setState(3);
            jsonResult.setMessage("密码错误");
            return jsonResult;
        }
        else {
            jsonResult.setState(1);
            httpSession.setAttribute("user",user1);
            return jsonResult;
        }

    }
}