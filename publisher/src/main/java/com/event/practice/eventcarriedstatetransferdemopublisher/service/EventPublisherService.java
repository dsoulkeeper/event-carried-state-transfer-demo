package com.event.practice.eventcarriedstatetransferdemopublisher.service;

import com.event.practice.eventcarriedstatetransferdemopublisher.dto.OrderDto;

public interface EventPublisherService {

    String TOPIC_EXCHANGE = "event-carried-state-transfer-example-topic-exchange";
    String TOPIC_EXCHANGE_QUEUE = "topic-exchange-order";
    String TOPIC_EXCHANGE_ORDER_ROUTING_KEY = "topic-exchange-order-routing-key";

    String FANOUT_EXCHANGE = "event-carried-state-transfer-example-fanout-exchange";
    String FANOUT_EXCHANGE_QUEUE_1 = "fanout-exchange-queue1";
    String FANOUT_EXCHANGE_QUEUE_2 = "fanout-exchange-queue2";
    String FANOUT_EXCHANGE_QUEUE_3 = "fanout-exchange-queue3";

    void publishOrderReceivedEvent(OrderDto orderDto);
}
