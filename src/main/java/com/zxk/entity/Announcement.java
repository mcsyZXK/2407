package com.zxk.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Announcement {
    private int id;
    private String title;
    private String message;
    private Timestamp updatedAt;
}
