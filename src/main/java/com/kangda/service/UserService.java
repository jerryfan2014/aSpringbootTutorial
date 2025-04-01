package com.kangda.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangda.po.User;
import org.springframework.stereotype.Service;

public interface UserService extends IService<User> {

    public boolean updateEmails();

    public String renderUserInfo();
}
