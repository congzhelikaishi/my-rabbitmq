package com.example.myrabbitmq.componentest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalReceiver {
    @RabbitHandler
    private void process(Map testMessage) {
        System.out.println("TopicTotalReceiver消费者收到的消息是："+testMessage.toString());
    }
}
