package com.zxk.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class RentalVO {
    private Integer id;
    private String email;
    private Integer cheNum;
    private Timestamp starttime;
    private Integer price;
}
