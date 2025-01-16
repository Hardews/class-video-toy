package com.example.mybilibili.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybilibili.dto.VideoLessInfoVo;
import com.example.mybilibili.entity.VideoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoMapper extends BaseMapper<VideoEntity> {
    @Select("SELECT * FROM video WHERE id >= #{pageStart} AND id <= #{pageEnd}")
    List<VideoEntity> selectVideoByPage(@Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd);

    @Select("SELECT id FROM video WHERE author_id = #{userId} AND title = #{title}")
    int selectVideoByAuthorAndTitle(@Param("userId") Long userId, @Param("title") String title);
}