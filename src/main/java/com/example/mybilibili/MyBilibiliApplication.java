package com.example.mybilibili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybilibili.mapper")
public class MyBilibiliApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBilibiliApplication.class, args);
    }
}
