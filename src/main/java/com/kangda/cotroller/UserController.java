package com.kangda.cotroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kangda.dto.SearchParam;
import com.kangda.po.User;
import com.kangda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kangda.api.Result;

import java.util.List;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestParam Long userId) {
        return userService.getById(1).toString();
    }

    @GetMapping("/getUserStat")
    public String getUserStat() {
        return userService.renderUserInfo();
    }

    @GetMapping("/list")
    public Result getUserList(){
        List<User> userList = userService.list();
        return Result.success(userList);
    }

    @PostMapping("/save")
    public Result createUser(@RequestBody User user){
        //支持新增insert 或者 更新 update
        boolean flag = userService.saveOrUpdate(user);
        if (!flag) {
            return Result.error("创建用户失败");
        }

        return Result.success(user);
    }

    @DeleteMapping("/del/{userId}")
    public Result deleteUser(@PathVariable Long userId){
        boolean flag = userService.removeById(userId);
        if (!flag) {
            return Result.error("删除用户失败");
        }

        return Result.success();
//        return Result.success(userId); 也可以返回被删除的userId
    }

    @GetMapping("/get/{userId}")
    public Result loadUser(@PathVariable Long userId){
        User user = userService.getById(userId);
        return Result.success(user);
    }

    @PostMapping("/search")
    public Result searchUser(@RequestBody SearchParam param) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if (!(param.getName() == null || param.getName().equals(""))) {
            userQueryWrapper.like("name", param.getName());
        }
        if (param.getAge() != null) {
            userQueryWrapper.gt("age", param.getAge());
        }

        List<User> userList = userService.list(userQueryWrapper);
        return Result.success(userList);
    }

}




























