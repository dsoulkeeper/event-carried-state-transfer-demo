package com.event.practice.publisher.service;

import com.event.practice.common.dto.OrderDto;

public interface EventPublisherService {

    void publishOrderReceivedEvent(OrderDto orderDto);
}
