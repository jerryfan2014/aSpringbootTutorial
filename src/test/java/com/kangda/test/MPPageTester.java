package com.kangda.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kangda.po.User;
import com.kangda.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MPPageTester {

    @Autowired
    private UserService userService;


    @Test
    public void testPagination(){
        //返回单页 current: 当前页号(要取的那一页）， size:页面大小（每页包含几条记录)
        IPage<User> userPage = userService.page(new Page<>(4, 3));
//        System.out.println(userPage.getRecords().size());
        for(User u: userPage.getRecords()) {
            System.out.println(u);
        }
    }

    @Test
    public void testPagination2(){
        List<User> userList = userService.list(new Page<>(4, 3));
        for (User u: userList) {
            System.out.println(u);
        }
    }
}
