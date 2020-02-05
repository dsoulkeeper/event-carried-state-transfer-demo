package com.event.practice.publisher.service.impl;

import com.event.practice.common.Constant;
import com.event.practice.common.dto.OrderDto;
import com.event.practice.publisher.service.EventPublisherService;
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
        rabbitTemplate.convertAndSend(Constant.TOPIC_EXCHANGE, Constant.TOPIC_EXCHANGE_ORDER_ROUTING_KEY,
                orderDto);

        // (For demo purpose) also sending to fanout exchange
        rabbitTemplate.convertAndSend(Constant.FANOUT_EXCHANGE, "", orderDto);
        log.info("Send {} over rabbitMq", orderDto);
    }
}
