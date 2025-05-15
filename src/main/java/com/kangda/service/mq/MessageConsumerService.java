package com.kangda.service.mq;


import com.kangda.po.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    @RabbitListener(queues = "email.queue")
    public void psubConsumEmail(Message message) {
        byte[] bytes = message.getBody();
        System.out.println("邮件队列接收到消息：" + new String(bytes));

    }

    @RabbitListener(queues = "sms.queue")
    public void psubConsumEmail(User user) {
        System.out.println("短信队列接收到消息：" + user.toString());
    }

}
