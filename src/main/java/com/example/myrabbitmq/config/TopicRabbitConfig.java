package com.example.myrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    /**
     * 绑定键
     */
    private final static String MAN = "topic.man";

    private final static String WOMAN = "topic.woman";

    /**
     * 定义队列
     */
    @Bean
    public Queue firstQueue() {
        return new Queue(TopicRabbitConfig.MAN);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(TopicRabbitConfig.WOMAN);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 将firstQueue和topicExchange绑定，并且绑定的键值是topic.man
     * 这样只要是消费携带的路由键是topic.man，才会分发到队列
     * @return
     */
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(MAN);
    }

    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");  // #:通配符，匹配多个词
    }

}
