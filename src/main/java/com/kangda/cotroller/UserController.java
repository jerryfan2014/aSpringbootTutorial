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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


    private String FILE_UPLOADED_DIR = "uploadedFiles";
    @PostMapping("/file/upload")
    public String uploadFile(@RequestParam("file") MultipartFile uploadedFile,
                             @RequestParam Long userId){
        //判断上传文件是否为空
        if(uploadedFile.isEmpty()) {
            return "文件为空，请上传";
        }
        //存放文件到本地： 读文件 -> 写文件
        try {
            //创建指定文件夹
            Files.createDirectories(Paths.get(FILE_UPLOADED_DIR));
            //定义文件存放路径
            Path destFilePath = Paths.get(FILE_UPLOADED_DIR
                    + File.separator
                    + uploadedFile.getOriginalFilename());

            //推荐方法2、springboot优化；效率高，安全
            uploadedFile.transferTo(destFilePath);

            return "文件上传成功";
        } catch (IOException e) {
            //@todo 写入日志文件
            return "文件上传失败" + e.getMessage();
        }
    }

}




























