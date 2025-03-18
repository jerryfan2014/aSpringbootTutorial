package com.kangda.helper;

import org.springframework.stereotype.Component;

@Component
public class PrintHelper {

    public String print(String msg) {
        return msg + "打印完毕";
    }
}
