package com.event.practice.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public final String TOPIC_EXCHANGE = "event-carried-state-transfer-example-topic-exchange";
    public final String TOPIC_EXCHANGE_QUEUE = "topic-exchange-order";
    public final String TOPIC_EXCHANGE_ORDER_ROUTING_KEY = "topic-exchange-order-routing-key";

    public final String FANOUT_EXCHANGE = "event-carried-state-transfer-example-fanout-exchange";
    public final String FANOUT_EXCHANGE_QUEUE_1 = "fanout-exchange-queue1";
    public final String FANOUT_EXCHANGE_QUEUE_2 = "fanout-exchange-queue2";
    public final String FANOUT_EXCHANGE_QUEUE_3 = "fanout-exchange-queue3";
}
