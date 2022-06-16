package com.example.myrabbitmq.test01;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 声明临时队列
                    exchange = @Exchange(value = "routesr", type = "direct"),
                    key = {"error"}
            )
    })
    public void receivel(String message) {
        System.out.println("C1 :"+message);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 声明临时队列
                    exchange = @Exchange(value = "routesr", type = "direct"),
                    key = {"error", "info"}
            )
    })
    public void receivel2(String message) {
        System.out.println("C2 :"+message);
    }
}
