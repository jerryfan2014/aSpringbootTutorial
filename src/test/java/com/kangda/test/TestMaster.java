package com.kangda.test;

import com.kangda.cotroller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMaster {


    @Test
    public void testHello() {
        HelloController ctrl = new HelloController();
        System.out.println(ctrl.hello("hello, springboot"));
    }

}
