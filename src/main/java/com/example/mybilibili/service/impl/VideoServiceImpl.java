package com.example.mybilibili.service.impl;

import com.example.mybilibili.dto.VideoInfoVo;
import com.example.mybilibili.dto.VideoLessInfoVo;
import com.example.mybilibili.entity.VideoEntity;
import com.example.mybilibili.mapper.VideoMapper;
import com.example.mybilibili.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper vm;

    // 一页展示视频数量
    private final int pageNum = 12;
    @Override
    public VideoInfoVo getVideoInfo(Long VideoId) {
        VideoEntity video = vm.selectById(VideoId);
        if (video == null) {
            // 没有这个 video
            return null;
        }

        return new VideoInfoVo(video);
    }

    @Override
    public List<VideoLessInfoVo> getVideoInfoByPagination(int pagination) {
        int pageStart = pagination - 1;
        int pageEnd = pageStart + pageNum;
        List<VideoEntity> vel = vm.selectVideoByPage(pageStart, pageEnd);
        if (vel.size() == 0){
            return null;
        }

        List<VideoLessInfoVo> vll = new ArrayList<>();
        for (VideoEntity videoEntity : vel) {
            vll.add(new VideoLessInfoVo(videoEntity));
        }

        return vll;
    }

    @Override
    public long getVideoCount() {
        return vm.selectVideoCount();
    }
}
