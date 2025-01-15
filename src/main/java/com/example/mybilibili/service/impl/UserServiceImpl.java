package com.example.mybilibili.service.impl;

import com.example.mybilibili.dto.LoginVo;
import com.example.mybilibili.dto.UserInfoVo;
import com.example.mybilibili.entity.UserEntity;
import com.example.mybilibili.mapper.UserMapper;
import com.example.mybilibili.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper um;

    @Override
    public UserInfoVo getInfo(Long id) {
        UserEntity user = um.selectById(id);
        if (user == null) {
            return null;
        }
        return new UserInfoVo(user);
    }

    @Override
    public Long login(LoginVo loginVo) {
        UserEntity user = um.selectByUsername(loginVo.getUsername());
        if (user == null){
            // 无此用户
            return -1L;
        }

        if (!Objects.equals(user.getPassword(), loginVo.getPassword())) {
            // 密码不对
            return -1L;
        }

        return user.getId();
    }
}
