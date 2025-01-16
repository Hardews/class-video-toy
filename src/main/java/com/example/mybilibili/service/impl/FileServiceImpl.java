package com.example.mybilibili.service.impl;

import com.example.mybilibili.dto.FileUploadVo;
import com.example.mybilibili.entity.VideoEntity;
import com.example.mybilibili.mapper.VideoMapper;
import com.example.mybilibili.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private VideoMapper vm;
    private String videoUploadDir = "/opt/videos/";
    private String videoUrlPrefix = "rtmp://8.130.31.247:1935/vod/";
    private String coverUploadDir = "/opt/photo/";
    private String coverUrlPrefix = "photo.hardews.cn/";
    @Override
    public int uploadFile(FileUploadVo f) {
        VideoEntity ve = new VideoEntity();

        // 时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = sdf.parse("2025-01-16 01:13:09");
            ve.setCreatedTime(new Time(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ve.setTitle(f.getTitle());
        ve.setIntroduction(f.getIntroduction());
        ve.setAuthorId(f.getUser_id());

        try {
            // 视频保存
            MultipartFile videoFile = f.getVideo();
            String videoFilename = videoFile.getOriginalFilename();
            File videoUploadedFile = new File(videoUploadDir + videoFilename);
            // 保存图片
            MultipartFile coverFile = f.getCover();
            String coverFilename = coverFile.getOriginalFilename();
            File coverUploadedFile = new File(coverUploadDir + coverFilename);

            // 数据库信息
            ve.setVideoUrl(videoUrlPrefix + videoFilename);
            ve.setCoverUrl(coverUrlPrefix + coverFilename);
            // 插入到数据库
            vm.insert(ve);

            // 确保成功插入到数据库后再进行文件保存
            videoFile.transferTo(videoUploadedFile);
            coverFile.transferTo(coverUploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        // 保存成功获取文件 id
        int id = vm.selectVideoByAuthorAndTitle(f.getUser_id(), f.getTitle());

        return id;
    }
}
