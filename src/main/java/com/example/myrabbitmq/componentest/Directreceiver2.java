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
public class Directreceiver2 {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息：" + testMessage.toString());
    }
}
/*
再创建 SeconrdDirectReceiver.java（代码和DirectReceiver 一致，只不过类名不一样） 第二个消费的监听类，对同一个队列监听，会不会出现重复消费的情况，根据实验证明，多个监听类监听同一个队列时不会出现重复消费的情况，而是采用轮询的方式消费队列中的信息
 */