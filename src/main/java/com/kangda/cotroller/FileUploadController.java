package com.kangda.cotroller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {
    //相对于应用根路径
    private String FILE_UPLOADED_DIR = "uploadedFiles";
    @PostMapping("/file/upload")
    public String uploadFile(@RequestParam("file") MultipartFile uploadedFile){
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

            //方法1、 读取上传文件内容； 大文件，效率不高、容易产生OOM
            //byte[] fileContent = uploadedFile.getBytes();
            //写入文件
            //Files.write(destFilePath, fileContent);

            //推荐方法2、springboot优化；效率高，安全
            uploadedFile.transferTo(destFilePath);

            return "文件上传成功";
        } catch (IOException e) {
            //@todo 写入日志文件
            return "文件上传失败" + e.getMessage();
        }
    }
}
