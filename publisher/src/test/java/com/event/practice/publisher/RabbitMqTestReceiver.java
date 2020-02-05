package com.event.practice.publisher;

import com.event.practice.common.dto.OrderDto;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.event.practice.publisher.service.EventPublisherService.FANOUT_EXCHANGE_QUEUE_1;
import static com.event.practice.publisher.service.EventPublisherService.FANOUT_EXCHANGE_QUEUE_2;
import static com.event.practice.publisher.service.EventPublisherService.FANOUT_EXCHANGE_QUEUE_3;
import static com.event.practice.publisher.service.EventPublisherService.TOPIC_EXCHANGE_QUEUE;

@Component
public class RabbitMqTestReceiver {

    private final BlockingQueue<OrderDto> messagesFromTopicExchange = new ArrayBlockingQueue(3);

    private final BlockingQueue<OrderDto> messagesFromFanoutExchangeToReceiver1 = new ArrayBlockingQueue(3);
    private final BlockingQueue<OrderDto> messagesFromFanoutExchangeToReceiver2 = new ArrayBlockingQueue(3);
    private final BlockingQueue<OrderDto> messagesFromFanoutExchangeToReceiver3 = new ArrayBlockingQueue(3);

    @RabbitListener(queues = TOPIC_EXCHANGE_QUEUE)
    public void receiveFromTopicExchange(OrderDto orderDto) {
        messagesFromTopicExchange.add(orderDto);
    }

    // 3 receivers to demonstrate fanout exchange behaviour
    @RabbitListener(queues = FANOUT_EXCHANGE_QUEUE_1)
    public void receiveFromFanoutExchangeToReceiver1(OrderDto orderDto) {
        messagesFromFanoutExchangeToReceiver1.add(orderDto);
    }

    @RabbitListener(queues = FANOUT_EXCHANGE_QUEUE_2)
    public void receiveFromFanoutExchangeToReceiver2(OrderDto orderDto) {
        messagesFromFanoutExchangeToReceiver2.add(orderDto);
    }

    @RabbitListener(queues = FANOUT_EXCHANGE_QUEUE_3)
    public void receiveFromFanoutExchangeToReceiver3(OrderDto orderDto) {
        messagesFromFanoutExchangeToReceiver3.add(orderDto);
    }

    @SneakyThrows
    public OrderDto fromTopicExchangeGetOrderOrWait() {
        return messagesFromTopicExchange.take();
    }

    @SneakyThrows
    public OrderDto fromFanoutExchangeReceiver1GetOrderOrWait() {
        return messagesFromFanoutExchangeToReceiver1.take();
    }

    @SneakyThrows
    public OrderDto fromFanoutExchangeReceiver2GetOrderOrWait() {
        return messagesFromFanoutExchangeToReceiver2.take();
    }

    @SneakyThrows
    public OrderDto fromFanoutExchangeReceiver3GetOrderOrWait() {
        return messagesFromFanoutExchangeToReceiver3.take();
    }
}
