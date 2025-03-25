package com.kangda.test;


import com.kangda.mapper.UserMapper;
import com.kangda.po.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class MPTester {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLoadById(){
        User user = userMapper.selectById(1);
        //@todo 对 user判空
        if (user != null) {
            StringBuffer sb = new StringBuffer("姓名：")
                    .append(user.getName())
                    .append(", 邮箱：")
                    .append(user.getEmail());
            System.out.println(sb.toString());
        } else {
            System.out.println("user is null!");
        }
    }

    @Test
    public void testLoadByMap(){
        Map param = new HashMap();
        //通过map对象设置查询条件
        param.put("name", "Tom");
        param.put("age",20);
        List<User> userList = userMapper.selectByMap(param);
        if (userList != null && !userList.isEmpty()) {
            //1 经典for循环
            for (int i=0; i < userList.size();i++) {
                User user = userList.get(i);
                System.out.println(user.getName() + " | " + user.getId());
            }

            //2 增强for循环，适合读
            for(User u : userList) {
                System.out.println(u.getName() + " | " + u.getId());
            }

            //3 集合对象的foreach方法，适合读
            userList.forEach(user -> {
                System.out.println(user.getName() + " | " + user.getId());
            });
        }
    }

    @Test
    public void testInsert() {
        //插入一条新数据到数据库
        User user = new User();
        user.setId(10L);
        user.setName("lisa");
        user.setEmail("lisa@kdvtc.edu.cn");
        //user.setAddrId(null);

        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testDelete(){
        int resultCnt = userMapper.deleteById(10);
        System.out.println(resultCnt);

        Map param = new HashMap();
        param.put("age", 18);

        int cnt = userMapper.deleteByMap(param);
        System.out.println("删除记录数：" + cnt);

    }


}
