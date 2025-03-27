package com.kangda.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kangda.mapper.UserMapper;
import com.kangda.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MPQueryWrapperTester {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLoad() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        //姓名以“小"字结尾
        //qw.likeLeft("name", "小");
        //姓名以“小"字开发
        //qw.likeRight("name", "小");
        //姓名中包含“小"字
        //qw.like("name", "o");

        //年龄大于20
        //qw.gt("age", 20);

        //年龄小于等于21
        //qw.le("age", 21);

        //查找姓名中包含“小”字 且年龄在18和28之间 且 邮箱地址包含“ming”的用户
        //qw.like("name", "小")
        //        .between("age", 18, 28)
        //        .like("email", "ming")
        //        .orderByDesc("name");

        //条件间默认 与 (and) 关系, 如果条件是或者关系，要用“or"连接
        //或者 or， 查找姓名是“小明”或者年龄大于等于28
//        qw.eq("name", "小明").or().ge("age", 28);
        qw.eq("name", "小明").ge("age", 28);

        List<User> userList = userMapper.selectList(qw);
        for(User u: userList) {
            System.out.println(u.getId() + ":" + u.getName());
        }
    }

}
