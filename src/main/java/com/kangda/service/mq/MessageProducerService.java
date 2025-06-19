package com.kangda.service.mq;

import com.kangda.po.User;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {
    private AmqpAdmin amqpAdmin;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageProducerService(AmqpAdmin amqpAdmin,
                                  RabbitTemplate rabbitTemplate){
        this.amqpAdmin = amqpAdmin;
        this.rabbitTemplate = rabbitTemplate;

        //定义exchange 为广播模式 fanout
        this.amqpAdmin.declareExchange(
                new FanoutExchange("pub/sub.exchange"));
        //创建queue
        this.amqpAdmin.declareQueue(new Queue("email.queue"));
        this.amqpAdmin.declareQueue(new Queue("sms.queue"));
        //bingding
        this.amqpAdmin.declareBinding(new Binding("email.queue",
                Binding.DestinationType.QUEUE,
                "pub/sub.exchange","", null));
        this.amqpAdmin.declareBinding(new Binding("sms.queue",
                Binding.DestinationType.QUEUE,
                "pub/sub.exchange","", null));
    }

    public void psubPubulish(User user) {
        this.rabbitTemplate.convertAndSend("pub/sub.exchange",
                "", user);
    }

}
