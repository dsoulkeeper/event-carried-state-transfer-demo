package com.event.practice.eventcarriedstatetransferdemopublisher.service;

import com.event.practice.eventcarriedstatetransferdemopublisher.dto.OrderDto;

public interface EventPublisherService {

    void publishOrderReceivedEvent(OrderDto orderDto);
}
