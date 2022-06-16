package com.example.myrabbitmq.test01;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class workconsumerDemo {

    @RabbitListener(queuesToDeclare = @Queue("worksr"))
    public void receivel(String message) {
        System.out.println("C1  :" + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("worksr"))
    public void receivel2(String message) {
        System.out.println("C2  :" + message);
    }
}
