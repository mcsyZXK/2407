package com.zxk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxk.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class IndexController {
    @RequestMapping("user.do")
    public void showUser(HttpSession session, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户未登录，重定向到登录页面
            response.sendRedirect("regin.html");
        } else {
            // 用户已登录，返回用户信息
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(user));
        }
    }
}
