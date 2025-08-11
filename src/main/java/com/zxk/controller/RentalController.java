package com.zxk.controller;

import com.zxk.entity.Rental;
import com.zxk.entity.User;
import com.zxk.mapper.RentalMapper;
import com.zxk.entity.JsonResult;
import com.zxk.entity.RentalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class RentalController {
    @Autowired
    RentalMapper rentalMapper;
    @ResponseBody
    @RequestMapping("/rentalus.do")
    public RentalVO[] showrental(HttpSession session){
        User user =(User)session.getAttribute("user");
        String email= user.getEmail();
        return rentalMapper.getUser(email);
    }
    @ResponseBody
    @RequestMapping("/rentals.do")
    public RentalVO[] showallrental(){
        return rentalMapper.getAll();
    }
    @CrossOrigin("/admin.html")
    @ResponseBody
    @RequestMapping("/rentald.do")
    public Integer deleterental(@RequestBody Rental rental){
        Integer id = rental.getId();
        System.out.println(id);
        return rentalMapper.deleteRental(id);
    }
    @RequestMapping("/rental.do")
    @ResponseBody
    @Transactional  // 启用事务管理
    public JsonResult insertRental(@RequestBody Rental[] rental) {
        JsonResult jsonResult = new JsonResult();
        try {
            for (Rental rental1 : rental) {
                int result = rentalMapper.insert(rental1);
                if (result == 0) {  // 如果某次插入失败，抛出异常
                    throw new RuntimeException("插入失败");
                }
            }
            jsonResult.setState(1);  // 所有插入成功
            jsonResult.setMessage("成功");
        } catch (Exception e) {
            // 如果发生异常，事务会自动回滚
            jsonResult.setState(0);
            jsonResult.setMessage("失败：" + e.getMessage());
        }
        return jsonResult;
    }
}
