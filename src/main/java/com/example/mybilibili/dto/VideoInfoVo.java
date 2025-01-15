package com.example.mybilibili.dto;

import com.example.mybilibili.entity.VideoEntity;
import lombok.Data;

import java.sql.Time;

@Data
public class VideoInfoVo {
    private Time created_time;
    private String title; // 视频标题
    private String introduction; // 视频简介
    private Long author_id; // 作者信息，外键：用户表
    private String cover_url; // 封面图片地址
    private String video_url; // 流地址

    public VideoInfoVo(VideoEntity video) {
        title = video.getTitle();
        video_url = video.getVideoUrl();
        introduction = video.getIntroduction();
        author_id = video.getAuthorId();
        created_time = video.getCreatedTime();
        cover_url = video.getCoverUrl();
    }
}
