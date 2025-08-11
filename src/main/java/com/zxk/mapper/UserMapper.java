package com.zxk.mapper;

import com.zxk.entity.User;

public interface UserMapper {
    Integer insert(User user);
    User findByEmail(String email);

}
