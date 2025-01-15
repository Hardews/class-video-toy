package com.example.mybilibili.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Time;

@Data
@TableName("`video`")
// 视频实体类
public class VideoEntity {
    private Long id;
    private Time createdTime;
    private String title; // 视频标题
    private String introduction; // 视频简介
    private Long authorId; // 作者信息id
    private String coverUrl; // 封面图片地址
    private String videoUrl; // 流地址
}
