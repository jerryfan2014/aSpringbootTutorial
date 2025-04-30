package com.kangda.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangda.po.User;
import org.springframework.stereotype.Service;

public interface UserService extends IService<User> {

    public boolean updateEmails();

    public String renderUserInfo();
    //从id为userIdForm的用户账号转账给id为userIdTo的用户，金额是amount
    public boolean transfer(Long userIdFrom, Long userIdTo, Double amount);

    public User getUserTotal(Long userId);

    public User getUserWithCache(Long userId);

    public void deleteUserWithCatch(Long userId);
}
