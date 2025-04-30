package com.kangda.test;

import com.kangda.po.User;
import com.kangda.service.UserService;
import com.kangda.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTester {

    @Autowired
    private UserService userService;

    @Test
    public void testFindUser(){
//        不带缓存的
//        User user = userService.getById(1L);
        User user= userService.getUserWithCache(16L);
//        System.out.println(user);
    }


    @Test
    public void testDeleteUser(){
      userService.deleteUserWithCatch(2L);
    }
}
