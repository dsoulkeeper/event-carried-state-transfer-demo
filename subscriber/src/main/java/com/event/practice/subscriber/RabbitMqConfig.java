package com.event.practice.subscriber;

import com.event.practice.common.Constant;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Declarables topicExchangeBindings() {
        TopicExchange topicExchange = new TopicExchange(Constant.TOPIC_EXCHANGE);
        Queue topicExchangeQueue = new Queue(Constant.TOPIC_EXCHANGE_QUEUE, false);
        return new Declarables(topicExchangeQueue, topicExchange, BindingBuilder
                .bind(topicExchangeQueue)
                .to(topicExchange)
                .with(Constant.TOPIC_EXCHANGE_ORDER_ROUTING_KEY)
        );
    }

    @Bean
    public Declarables fanoutExchangeBindings() {
        FanoutExchange fanoutExchange = new FanoutExchange(Constant.FANOUT_EXCHANGE);
        Queue fanoutExchangeQueue1 = new Queue(Constant.FANOUT_EXCHANGE_QUEUE_1, false);
        Queue fanoutExchangeQueue2 = new Queue(Constant.FANOUT_EXCHANGE_QUEUE_2, false);
        Queue fanoutExchangeQueue3 = new Queue(Constant.FANOUT_EXCHANGE_QUEUE_3, false);
        return new Declarables(
                fanoutExchangeQueue1,
                fanoutExchangeQueue2,
                fanoutExchangeQueue3,
                fanoutExchange,
                BindingBuilder.bind(fanoutExchangeQueue1).to(fanoutExchange),
                BindingBuilder.bind(fanoutExchangeQueue2).to(fanoutExchange),
                BindingBuilder.bind(fanoutExchangeQueue3).to(fanoutExchange));
    }

}
