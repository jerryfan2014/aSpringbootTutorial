package com.kangda.cotroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kangda.dto.SearchParam;
import com.kangda.po.User;
import com.kangda.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kangda.api.Result;

import java.util.List;

@RestController
@RequestMapping("/user")
//@Api(value="用户模块", tags={"用户管理"})
@Tag(name = "用户模块")
//@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUserStat")
    @Operation(summary = "统计用户信息")
    public String getUserStat() {
        return userService.renderUserInfo();
    }

//    @ApiOperation("获取用户列表")
    @Operation(summary = "获取用户列表")
    @GetMapping("/list")
    public Result getUserList(){
        List<User> userList = userService.list();
        return Result.success(userList);
    }

    @PostMapping("/save")
    @Operation(summary = "新增用户")
    public Result createUser(@RequestBody User user){
        //支持新增insert 或者 更新 update
        boolean flag = userService.saveOrUpdate(user);
        if (!flag) {
            return Result.error("创建用户失败");
        }

        return Result.success(user);
    }

    @DeleteMapping("/del/{userId}")
    @Operation(summary = "删除用户")
    public Result deleteUser(@PathVariable Long userId){
        boolean flag = userService.removeById(userId);
        if (!flag) {
            return Result.error("删除用户失败");
        }

        return Result.success();
//        return Result.success(userId); 也可以返回被删除的userId
    }

    @GetMapping("/get/{userId}")
    @Operation(summary = "获取用户信息")
    public Result loadUser(@PathVariable Long userId){
        User user = userService.getById(userId);
        if(user != null) {
            return Result.success(user);
        } else {
            return  Result.success("操作成功，用户不存在");
        }
    }

    @PostMapping("/search")
    @Operation(summary = "用户查询")
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




























