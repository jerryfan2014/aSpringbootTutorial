package com.kangda.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangda.mapper.UserAccountMapper;
import com.kangda.mapper.UserMapper;
import com.kangda.po.User;
import com.kangda.po.UserAccount;
import com.kangda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserAccountMapper userAccountMapper;

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

    @Override
    @Transactional()
    public boolean transfer(Long userIdFrom, Long userIdTo, Double amount) {
        if (userIdFrom == null || userIdTo == null) {
            throw new RuntimeException("参数非法");
        }
        if (userIdFrom.equals(userIdTo)) {
            throw new RuntimeException("转入账户和转出账户为同一账户");
        }
        if (amount != null && amount <= 0) {
            throw new RuntimeException("转账金额非法(<=0)");
        }
        //转出账户
        UserAccount userAccountFrom = userAccountMapper.selectById(userIdFrom);
        //转入账户
        UserAccount userAccountTo = userAccountMapper.selectById(userIdTo);
        if (userAccountFrom == null) {
            throw new RuntimeException("id为 " + userIdFrom + " 的账户不存在");
        }
        if (userAccountTo == null) {
            throw new RuntimeException("id为 " + userIdFrom + " 的账户不存在");
        }
        //钱不够
        if (userAccountFrom.getAccountBalance() < amount) {
            throw new RuntimeException("id为 " + userIdFrom + " 的账户的余额不足");
        }
        //转出账户扣除转账金额
        userAccountFrom.setAccountBalance(userAccountFrom.getAccountBalance() - amount);
        //转入账户增加转账金额
        userAccountTo.setAccountBalance(userAccountTo.getAccountBalance() + amount);
        //保存修改后的数据
        userAccountMapper.updateById(userAccountFrom);
//        if ( true) {
//            throw new RuntimeException("抛出异常，模拟断网,断电，硬件故障等突发故障");
//        }
        userAccountMapper.updateById(userAccountTo);
        return true;
    }
}
