package com.example.mybilibili.controller;

import com.example.mybilibili.dto.FileUploadVo;
import com.example.mybilibili.service.FileService;
import com.example.mybilibili.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fs;

    @PostMapping("")
    private R uploadFile(FileUploadVo f) {
        int id = fs.uploadFile(f);
        return R.ok().put("video_id", id);
    }
}
