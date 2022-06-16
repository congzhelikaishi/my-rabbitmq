package com.example.myrabbitmq.test01;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 创建消费者
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hellosr"))
public class helloconsumer {

    @RabbitHandler
    public void receivel(String message) {
        System.out.println(message);
    }
}
