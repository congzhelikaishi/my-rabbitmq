package com.example.myrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Direct exchange(直连交换机测试)
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 定义队列
     */
    @Bean
    public Queue testDirectQueue() {
        /*
        testDirectRabbit 是自定义的队列
        durable 是否持久化，默认就是false
        持久化队列 会存储到磁盘上，当消息代理重启时仍然存在
        暂缓队列 当前连接有效
        exclusive 默认也是false 只能被当前创建的连接使用，而且当前队列关闭后队列立即删除
        autoDelete 是否自动删除，当前没有生产者或者消费者使用此队列时，该对列会自动删除
        return new Queue("testDirectRabbit", true, false, false);
        一般设置一下对列的持久化就行，其余两个默认false就行
         */
        return new Queue("testDirectQueue", true);
    }

    /**
     * 定义direct 交换机
     * @return
     */
    @Bean
    public DirectExchange testDirectExchange() {
        // 三个参数分别是：name, durable, autoDelete
        return new DirectExchange("testDirectExchange", true, false);
    }

    /**
     * 绑定
     * @return
     */
    @Bean
    public Binding bingingDirect() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("testDirectRouting");
    }

    @Bean
    public DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }

}
