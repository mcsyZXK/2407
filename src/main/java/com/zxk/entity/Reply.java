package com.zxk.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Reply {
    private Integer id;
    private Integer anid;
    private String retext;
    private String username;
    private Date timestamp;

}
