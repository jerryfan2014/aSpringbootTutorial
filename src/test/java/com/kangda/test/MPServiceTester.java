package com.kangda.test;


import com.kangda.po.User;
import com.kangda.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MPServiceTester {

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        User user =  userService.getById(1);
        System.out.println(user.getId() + "---" + user.getName());
    }
}
