package com.example.myrabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class sendMessageController {

    /**
     * 使用rabbit模板
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("massageId", messageId);
        map.put("massageData", messageData);
        map.put("createTime", createTime);

        //将消息携带绑定键值：testDirectRouting 发送到交换机testDirectExchange
        rabbitTemplate.convertAndSend("testDirectExchange", "testDirectRouting", map);
        return "test Direct exchange";
    }

    /**
     * 接口推送消息
     * @return
     */
    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("massageId", messageId);
        map.put("massageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        return "send FanoutMessage";
    }

    @GetMapping("/sendTopicMessage1")
        public String sendTopicMessage1() {
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData = "message, M A N";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<>();
            map.put("massageId", messageId);
            map.put("massageData", messageData);
            map.put("createTime", createTime);
            rabbitTemplate.convertAndSend("topicExchange", "topic.man", map);
            return "send TopicMessage1";
    }

    @GetMapping("/sendTopicMessage2")
        public String sendTopicMessage2() {
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData = "message, WOMAN is all";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<>();
            map.put("massageId", messageId);
            map.put("massageData", messageData);
            map.put("createTime", createTime);
            rabbitTemplate.convertAndSend("topicExchange", "topic.woman", map);
            return "send TopicMessage2";
    }


}
