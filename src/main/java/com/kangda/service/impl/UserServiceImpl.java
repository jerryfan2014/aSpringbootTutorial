package com.kangda.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangda.mapper.UserMapper;
import com.kangda.po.User;
import com.kangda.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}
