package com.kangda.cotroller;


import com.kangda.po.User;
import com.kangda.service.mq.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqController {

    @Autowired
    private MessageProducerService messageProducerService;

    @GetMapping("/mq/publish")
    public String publishMessage(){
        User user = new User();
        user.setName("tom");
        user.setAge(18);
        messageProducerService.psubPubulish(user);

        return user.toString();
    }


}
