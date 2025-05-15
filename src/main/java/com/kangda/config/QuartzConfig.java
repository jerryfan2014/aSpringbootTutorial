//package com.kangda.config;
//
//import com.kangda.task.QuartzJob;
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail jobDetail(){
//        return JobBuilder.newJob(QuartzJob.class)
//                .withIdentity("quartzJob001")
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger jobTrigger(){
//        String cronExp = "*/10 * *  * * ?";
//        return TriggerBuilder.newTrigger().forJob(jobDetail())
//                .withIdentity("jobDetailTrigger")
//                .withSchedule(CronScheduleBuilder
//                        .cronSchedule(cronExp))
//                .build();
//    }
//}
