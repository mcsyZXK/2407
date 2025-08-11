package com.zxk.controller;

import com.zxk.entity.Announcement;
import com.zxk.mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnouncementController {
    @Autowired
    AnnouncementMapper announcementMapper;
    @RequestMapping("announcements.do")
    @ResponseBody
    public Announcement[] showAn(){
        return announcementMapper.getAll();
    }
}
