package com.zxk;

import com.zxk.entity.Announcement;
import com.zxk.entity.Car;
import com.zxk.entity.Reply;
import com.zxk.mapper.*;
import com.zxk.entity.RentalVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testcase {
    ClassPathXmlApplicationContext ctx;
    UserMapper userMapper;
    CarMapper carMapper;
    RentalMapper rentalMapper;
    ReplyMapper replyMapper;
    AnnouncementMapper announcementMapper;


    @Test
    public void findAll(){
        Announcement[] announcements=announcementMapper.getAll();
        for (Announcement announcement:announcements){
            System.out.println(announcement);
        }
        Car[] cars =carMapper.findAll();
        for (Car car:cars){
            System.out.println(car);
        }
    }


    @Before //修饰的方法会在测试方法@Test的之前执行
    public void init(){
        ctx = new ClassPathXmlApplicationContext("spring-dao.xml");
        rentalMapper = ctx.getBean("rentalMapper",RentalMapper.class);
        userMapper = ctx.getBean("userMapper",UserMapper.class);
        carMapper= ctx.getBean("carMapper",CarMapper.class);
        replyMapper = ctx.getBean("replyMapper",ReplyMapper.class);
        announcementMapper = ctx.getBean("announcementMapper",AnnouncementMapper.class);
    }

    @After //修饰的方法会在测试方法@Test的之后执行
    public void destory(){
        ctx.close();
    }


}