package com.example.mybilibili.controller;

import com.example.mybilibili.dto.VideoInfoVo;
import com.example.mybilibili.dto.VideoLessInfoVo;
import com.example.mybilibili.service.VideoService;
import com.example.mybilibili.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService vs;

    @GetMapping("")
    private R getVideoInfo(Long id) {
        VideoInfoVo v = vs.getVideoInfo(id);
        return R.ok().put("info", v);
    }

    @GetMapping("/page")
    private R getVideoInfoByPagination(int pagination) {
        if (pagination == 0){
            pagination = 1;
        }
        List<VideoLessInfoVo> vli = vs.getVideoInfoByPagination(pagination);
        return R.ok().put("info", vli);
    }
}
