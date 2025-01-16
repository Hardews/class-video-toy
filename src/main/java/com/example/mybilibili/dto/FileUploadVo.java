package com.example.mybilibili.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadVo {
    Long user_id;
    MultipartFile video, cover;
    String title;
    String introduction;
}
