package com.event.practice.eventcarriedstatetransferdemopublisher.service.impl;

import com.event.practice.eventcarriedstatetransferdemopublisher.dto.OrderDto;
import com.event.practice.eventcarriedstatetransferdemopublisher.service.EventPublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventPublisherServiceImpl implements EventPublisherService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publishOrderReceivedEvent(OrderDto orderDto) {
        // sending to topic exchange
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, TOPIC_EXCHANGE_ORDER_ROUTING_KEY,
                orderDto);

        // (For demo purpose) also sending to fanout exchange
        rabbitTemplate.convertAndSend(FANOUT_EXCHANGE, "", orderDto);
        log.info("Send {} over rabbitMq", orderDto);
    }
}
