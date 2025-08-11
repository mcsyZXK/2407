package com.zxk.entity;

import lombok.Data;

@Data
public class User {

    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String pictureUrl;
}