package com.zxk.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Rental {
    private Integer id;
    private String email;
    private Integer cheNum;
    private Timestamp starttime;

}
