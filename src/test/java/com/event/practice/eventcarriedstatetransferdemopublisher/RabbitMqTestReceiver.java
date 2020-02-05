package com.event.practice.eventcarriedstatetransferdemopublisher;

import com.event.practice.eventcarriedstatetransferdemopublisher.dto.OrderDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
public class RabbitMqTestReceiver {

    private final BlockingQueue<OrderDto> queue = new ArrayBlockingQueue(10);
    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public void receive(String orderDtoJson) {
        queue.add(objectMapper.readValue(orderDtoJson, OrderDto.class));
    }

    @SneakyThrows
    public OrderDto getOrderOrWait() {
        return queue.take();
    }
}
