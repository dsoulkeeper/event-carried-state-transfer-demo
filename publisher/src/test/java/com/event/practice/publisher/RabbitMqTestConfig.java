package com.event.practice.publisher;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.event.practice.publisher.service.EventPublisherService.FANOUT_EXCHANGE;
import static com.event.practice.publisher.service.EventPublisherService.FANOUT_EXCHANGE_QUEUE_1;
import static com.event.practice.publisher.service.EventPublisherService.FANOUT_EXCHANGE_QUEUE_2;
import static com.event.practice.publisher.service.EventPublisherService.FANOUT_EXCHANGE_QUEUE_3;
import static com.event.practice.publisher.service.EventPublisherService.TOPIC_EXCHANGE;
import static com.event.practice.publisher.service.EventPublisherService.TOPIC_EXCHANGE_ORDER_ROUTING_KEY;
import static com.event.practice.publisher.service.EventPublisherService.TOPIC_EXCHANGE_QUEUE;

@Configuration
public class RabbitMqTestConfig {

    @Bean
    public Declarables topicExchangeBindings() {
        TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE);
        Queue topicExchangeQueue = new Queue(TOPIC_EXCHANGE_QUEUE, false);
        return new Declarables(topicExchangeQueue, topicExchange, BindingBuilder
                .bind(topicExchangeQueue)
                .to(topicExchange)
                .with(TOPIC_EXCHANGE_ORDER_ROUTING_KEY)
        );
    }

    @Bean
    public Declarables fanoutExchangeBindings() {
        FanoutExchange fanoutExchange = new FanoutExchange(FANOUT_EXCHANGE);
        Queue fanoutExchangeQueue1 = new Queue(FANOUT_EXCHANGE_QUEUE_1, false);
        Queue fanoutExchangeQueue2 = new Queue(FANOUT_EXCHANGE_QUEUE_2, false);
        Queue fanoutExchangeQueue3 = new Queue(FANOUT_EXCHANGE_QUEUE_3, false);
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
