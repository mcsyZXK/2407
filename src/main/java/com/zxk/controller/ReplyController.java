package com.zxk.controller;

import com.zxk.entity.JsonResult;
import com.zxk.entity.Reply;
import com.zxk.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReplyController {
    @Autowired
    ReplyMapper replyMapper;
    @ResponseBody
    @RequestMapping("/reply.do")
    public Reply[] ShowAllReply(){return replyMapper.getAllReply(); }
    @RequestMapping("/ireply.do")
    @ResponseBody
    public JsonResult InsertReply(@RequestBody Reply reply){
        Integer integer =replyMapper.insertReply(reply);
        JsonResult jsonResult=new JsonResult();
        if(integer==0){
            jsonResult.setState(0);
            jsonResult.setMessage("失败");
            return jsonResult;
        }
        else {
            jsonResult.setState(1);
            jsonResult.setMessage("成功");
            return jsonResult;
        }
    }
}
