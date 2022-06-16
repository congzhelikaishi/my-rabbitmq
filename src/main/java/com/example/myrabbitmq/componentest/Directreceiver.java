package com.example.myrabbitmq.componentest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * testDirectRabbit 是监听名称
 */
@Component
@RabbitListener(queues = "testDirectQueue")
public class Directreceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息：" + testMessage.toString());
    }
}
