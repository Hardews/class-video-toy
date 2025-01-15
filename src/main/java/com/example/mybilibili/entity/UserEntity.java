package com.example.mybilibili.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`user`")
public class UserEntity {
    private Long id;
    private String avatarUrl; // 头像地址
    private String nickName; // 昵称
    private String introduction; // 简介

    private String username; // 用户名
    private String password; // 密码
}
