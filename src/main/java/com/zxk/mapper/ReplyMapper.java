package com.zxk.mapper;

import com.zxk.entity.Reply;
public interface ReplyMapper {
    Reply[] getAllReply();
    Integer insertReply(Reply reply);
}
