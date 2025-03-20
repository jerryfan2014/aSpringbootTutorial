package com.kangda.test;


import com.kangda.mapper.UserMapper;
import com.kangda.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MPTester {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLoad(){
        User user = userMapper.selectById(1);
        StringBuffer sb = new StringBuffer("姓名：")
                .append(user.getName())
                .append(", 邮箱：")
                .append(user.getEmail());
        System.out.println(sb.toString());
    }
}
