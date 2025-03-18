package com.kangda;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Springboot启动类, 启动类就是包含main方法的class
@SpringBootApplication
public class HelloSpringboot {

    public static void main(String[] args) {

        SpringApplication.run(HelloSpringboot.class, args);
    }
}
