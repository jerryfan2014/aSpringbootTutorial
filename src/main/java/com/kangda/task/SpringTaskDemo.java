package com.kangda.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Calendar;

//@Service
public class SpringTaskDemo {

//    每隔5秒执行一次
    @Scheduled(cron = "*/5 * * * * ?")
    public void printMessage1(){
        System.out.println("printMessage【1】每5秒调度一次：" + Calendar.getInstance().getTime());
    }

    @Scheduled(fixedRate = 10000)
    public void printMessage2(){
        System.out.println("printMessage【2】每10秒调度一次：" + Calendar.getInstance().getTime());
    }
}
