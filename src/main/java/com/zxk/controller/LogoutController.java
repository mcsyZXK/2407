package com.zxk.controller;

import com.zxk.entity.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/logout.do")
    @ResponseBody
    public JsonResult logout(HttpSession session){
        session.invalidate();
        return new JsonResult();
    }
}
