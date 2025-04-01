package com.kangda.cotroller;

import com.kangda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/user/getUserInfo")
    public String getUserInfo(@RequestParam Long userId) {
        return userService.getById(1).toString();
    }

    @GetMapping("/user/getUserStat")
    public String getUserStat() {

        return userService.renderUserInfo();
    }
}
