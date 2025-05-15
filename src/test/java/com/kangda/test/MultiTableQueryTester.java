package com.kangda.test;

import com.kangda.dto.UserDTO;
import com.kangda.mapper.UserMapper;
import com.kangda.po.User;
import com.kangda.service.db.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MultiTableQueryTester {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserInfo(){
        List<Map<String, Object>> userList = userMapper.getUserInfo();
        //增强for
        for(Map<String, Object> userMap: userList) {
            //获取map的key的集合的迭代器
            Iterator<String> it = userMap.keySet().iterator();
            while (it.hasNext()) {
                //字段名
                String fieldName = it.next();
                //字段值
                Object fieldValue = userMap.get(fieldName);
                System.out.println(fieldName + ":" + fieldValue);
            }
        }
    }

    @Test
    public void testGetUserInfoAsDTO(){
        List<UserDTO> userDTOList = userMapper.getUserInfoAsDTO();
        for(UserDTO  userDTO: userDTOList) {
            System.out.println(userDTO);
        }
    }

    @Test
    public void testGetUserById(){
        UserDTO user = userMapper.getUserDTOById(1L);
        System.out.println(user);
    }

    @Test
    public void testGetUserInfoWithXML(){
        List<UserDTO> userDTOList = userMapper.getUserInfoWithXML();
        for(UserDTO  userDTO: userDTOList) {
            System.out.println(userDTO);
        }
    }

    @Test
    public void testGetUserByIdWithXML(){
        UserDTO user = userMapper.getUserInfoByIdWithXML(2L);
        System.out.println(user);
    }

    @Test
    public void testSelectUserWithAddress(){
        User user = userMapper.selectUserWithAddress(4L);
        if (user.getUserAddress() != null) {
            System.out.println(user.getUserAddress().getAddress());
        }
    }

    @Test
    public void testSelectUserWithAccount(){
        User user = userMapper.selectUserWithAccount(2L);
        System.out.println(user.getUserAccountList().size());
    }

    @Test
    public void testSelectUserTotal(){
        User user = userService.getUserTotal(1L);
        System.out.println(user.getUserAddress().getAddress());
        System.out.println(user.getUserAccountList().size());
    }
}
