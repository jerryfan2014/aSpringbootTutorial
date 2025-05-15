package com.kangda.task;

import com.kangda.service.db.OrderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class QuartzJob implements Job {

    @Autowired
    private OrderService orderService;

//    初始值为0
//    maxId需要数据库持久化，不能放到类；每次调度，都是new QuartzJob
    private Long maxId = 0L;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Long added  = orderService.getOrdersAdded(maxId);
//        当前最新的maxId ？
        Long newMaxId = orderService.getMaxId(maxId);
//        修改maxId的值为新的maxId
        maxId = newMaxId;
        System.out.println(this.toString());
    }
}
