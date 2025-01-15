package com.example.mybilibili.service;

import com.example.mybilibili.dto.VideoInfoVo;
import com.example.mybilibili.dto.VideoLessInfoVo;

import java.util.List;

public interface VideoService {
    VideoInfoVo getVideoInfo(Long videoId);
    List<VideoLessInfoVo> getVideoInfoByPagination(int page);
}
