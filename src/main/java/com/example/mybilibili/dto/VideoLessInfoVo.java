package com.example.mybilibili.dto;

import com.example.mybilibili.entity.VideoEntity;
import lombok.Data;

import java.sql.Time;

@Data
public class VideoLessInfoVo {
    private Long video_id;
    private Time created_time;
    private String title; // 视频标题
    private String cover_url; // 封面图片地址

    public VideoLessInfoVo(VideoEntity ve) {
        video_id = ve.getId();
        created_time = ve.getCreatedTime();
        title = ve.getTitle();
        cover_url = ve.getCoverUrl();
    }
}
