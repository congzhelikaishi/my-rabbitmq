package com.example.myrabbitmq.componentest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.man")
public class Topicreceiver {
    @RabbitHandler
    private void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到的消息是："+testMessage.toString());
    }
}
