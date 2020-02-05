package com.event.practice.eventcarriedstatetransferdemopublisher.service.impl;

import com.event.practice.eventcarriedstatetransferdemopublisher.dto.OrderDto;
import com.event.practice.eventcarriedstatetransferdemopublisher.service.EventPublisherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventPublisherServiceImpl implements EventPublisherService {

    private final RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @SneakyThrows
    public void publishOrderReceivedEvent(OrderDto orderDto) {
        rabbitTemplate.convertAndSend("event-carried-state-transfer-example", "order",
                objectMapper.writeValueAsString(orderDto));
        log.info("Send {} over rabbitMq", orderDto);
    }
}
