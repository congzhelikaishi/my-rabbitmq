package com.example.myrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class MyRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 生产者
    @Test
    void contextLoads() {
        // 第一个参数：发送的队列 第二个参数：发送的信息
        rabbitTemplate.convertAndSend("hellosr", "hello spring boot rabbitmq");
    }

    // workqueue模式（拿到消息即销毁）
    @Test
    void testwork() {
        IntStream.range(0,10).forEach(i -> rabbitTemplate.convertAndSend("worksr", "hello spring boot rabbitmq"+i));
    }

    // Public模型（发布订阅、fanout模型）
    @Test
    void testfanout() {
        rabbitTemplate.convertAndSend("fanoutsr", "","hello spring boot rabbitmq");
    }

    // Routing (静态路由模型)
    @Test
    void testRoute() {
        rabbitTemplate.convertAndSend("routesr", "info", "hello spring boot rabbitmq");
    }

    // topics(动态路由)
    @Test
    void testTopic() {
        rabbitTemplate.convertAndSend("topicsr", "order.save.oid", "hello spring boot rabbitmq");
    }

}
