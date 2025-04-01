package com.kangda.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangda.mapper.UserMapper;
import com.kangda.po.User;
import com.kangda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean updateEmails() {
        //更新小芳、小明、lisa的邮箱信息
        //User xiaoFang = userMapper.selectById(8);
        //User xiaoFang = this.getById(8);
        User xiaoFang = new User();
        xiaoFang.setId(8L);
        xiaoFang.setEmail("xiaofang2025@abc.com");
        this.saveOrUpdate(xiaoFang);

        User xiaoMing = this.getById(11);
        xiaoMing.setEmail("xiaoming2025@abc.com");
        this.updateById(xiaoMing);

        User lisa = this.getById(16);
        lisa.setEmail("lisa2025@abc.com");
        this.updateById(lisa);

        return true;
    }

    @Override
    public String renderUserInfo() {
        //从数据库查询所有记录并以表格形式在前端（浏览器）展示；在表格末尾增加显示用户的平均年龄
        List<User> userList = this.list();
        //遍历userList， 生成user信息的table
        StringBuffer sb = new StringBuffer();
        sb.append("<html>").append("<table border='2'>");
        //生成表头
        sb.append("<tr>")
            .append("<td align='center'>ID</td>")
            .append("<td>NAME</td>")
            .append("<td>AGE</td>")
            .append("<td>EMAIL</td>")
            .append("</tr>");
        int totalAge = 0;
        for(User u: userList) {
            sb.append("<tr>");
            sb.append("<td>").append(u.getId()).append("</td>");
            sb.append("<td>").append(u.getName()).append("</td>");
            sb.append("<td>").append(u.getAge()).append("</td>");
            sb.append("<td>").append(u.getEmail()).append("</td>");
            sb.append("</tr>");
            totalAge += u.getAge();
        }
        sb.append("<tr>").append("<td>平均年龄</td>")
                .append("<td colspan='3' align='center'>").append(totalAge / userList.size())
                .append("</td>").append("</tr>");
        sb.append("</table>").append("</html>");
        //计算user的平均年龄
        // 1 遍历userList对象的时候，可以计算； 2 写一个sql语句，计算字段

        return sb.toString();
    }
}
