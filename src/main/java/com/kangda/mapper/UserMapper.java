package com.kangda.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangda.dto.UserDTO;
import com.kangda.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT u.id, u.name, u.age, u.email ," +
            " ua.account_type, ua.account_balance" +
            " FROM user u LEFT JOIN user_account ua " +
            " ON u.id = ua.user_id" +
            " ORDER BY u.id ASC ")
    public List<Map<String, Object>> getUserInfo();

    @Select("SELECT u.id, u.name, u.age, u.email ," +
            " ua.account_type, ua.account_balance" +
            " FROM user u LEFT JOIN user_account ua " +
            " ON u.id = ua.user_id" +
            " ORDER BY u.id ASC ")
    public List<UserDTO> getUserInfoAsDTO();


    @Select("SELECT u.id, u.name, u.age, u.email ," +
            " ua.account_type, ua.account_balance" +
            " FROM user u LEFT JOIN user_account ua " +
            " ON u.id = ua.user_id" +
            " WHERE u.id=#{userId}")
    public  UserDTO getUserDTOById(Long userId);

    //方法名要和UserMapper.xml文件中的某一个<select>标签的id属性值相等
    public List<UserDTO> getUserInfoWithXML();
    public UserDTO getUserInfoByIdWithXML(Long id);

    //one-to-one 1对1关系
    public User selectUserWithAddress(Long userId);

    //one-to-many 1对多关系
    public User selectUserWithAccount(Long userId);

    // 同时加载one-to-one和one-to-many关系的对象
    public User selectUserTotal(Long userId);

}
