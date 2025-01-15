package com.example.mybilibili.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybilibili.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    @Select("SELECT * FROM user WHERE username = #{username}")
    UserEntity selectByUsername(String username);
}
