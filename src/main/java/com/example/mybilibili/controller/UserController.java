package com.example.mybilibili.controller;

import com.example.mybilibili.dto.LoginVo;
import com.example.mybilibili.dto.UserInfoVo;
import com.example.mybilibili.service.UserService;
import com.example.mybilibili.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService us;

    @PostMapping("/login")
    private R login(@RequestBody LoginVo lv) {
        Long id = us.login(lv);
        return R.ok().put("id", id);
    }

    @GetMapping("/info")
    private R getInfo(Long id) {
        UserInfoVo info = us.getInfo(id);
        return R.ok().put("info", info);
    }
}
