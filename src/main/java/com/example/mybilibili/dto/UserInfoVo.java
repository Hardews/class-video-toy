package com.example.mybilibili.dto;

import com.example.mybilibili.entity.UserEntity;
import lombok.Data;

@Data
public class UserInfoVo {
    private String avatar_url; // 头像地址
    private String nick_name; // 昵称
    private String introduction; // 简介

    public UserInfoVo(UserEntity user) {
        avatar_url = user.getAvatarUrl();
        nick_name = user.getNickName();
        introduction = user.getIntroduction();
    }
}
