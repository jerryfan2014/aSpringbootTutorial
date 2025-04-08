package com.kangda.test;


import com.kangda.po.User;
import com.kangda.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MPServiceTester {

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        User user =  userService.getById(1);
        System.out.println(user.getId() + "---" + user.getName());
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("lisa");
        user.setAge(29);
        user.setEmail("lisa@kdvtc.edu.cn");
        boolean flag = userService.save(user);
        System.out.println("执行结果：" + flag);
    }
    @Test
    public void testUpdate(){
        User user = userService.getById(1);
        user.setEmail("xiaoming2015@abc.com");
        // 1 saveOrUpdate
        // boolean flag = userService.saveOrUpdate(user);
        // 2 update
         boolean flag = userService.updateById(user);
        System.out.println("执行结果：" + flag);
    }
    @Test
    public void  testDelete(){
        //删除单条记录
        boolean flag = userService.removeById(17);
        System.out.println("执行结果：" + flag);

        //删除多条记录
        List idList = new ArrayList();
        idList.add(12);
        idList.add(14);
        idList.add(15);
        boolean flag2 = userService.removeByIds(idList);
        System.out.println("执行结果：" + flag2);
    }

    @Test
    public void testEmailUpdates() {
        System.out.println(userService.updateEmails());
    }


    @Test
    public void testTransfer(){
        userService.transfer(1L, 1L, 1000d);
    }
}
