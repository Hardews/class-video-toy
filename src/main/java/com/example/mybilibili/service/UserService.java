package com.example.mybilibili.service;

import com.example.mybilibili.dto.LoginVo;
import com.example.mybilibili.dto.UserInfoVo;

public interface UserService {
    UserInfoVo getInfo(Long id);
    Long login(LoginVo loginVo);
}
