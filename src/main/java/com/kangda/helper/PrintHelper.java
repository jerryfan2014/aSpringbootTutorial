package com.kangda.helper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@RestController
@Service
//@Repository
public class PrintHelper {

    public String print(String msg) {
        return msg + "打印完毕";
    }
}
