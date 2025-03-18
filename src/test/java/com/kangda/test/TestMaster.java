package com.kangda.test;

import com.kangda.cotroller.HelloController;
import com.kangda.helper.PrintHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMaster {

    @Autowired
    private HelloController helloController;

    @Autowired
    private PrintHelper printHelper;


    @Test
    public void testHello() {
//        传统开发，开发人员负责创建和管理对象
//        HelloController ctrl = new HelloController();
//        System.out.println(ctrl.hello("hello, springboot"));

//      springboot中， 由spring容器接管对象创建和管理
        System.out.println(helloController.hello("hello, springboot"));
    }


    @Test
    public void testPrint(){
        System.out.println(printHelper.print("xxx使用说明书"));
    }

}
