package com.event.practice.subscriber;

import com.event.practice.common.Constant;
import com.event.practice.common.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMqReceiver {

    @RabbitListener(queues = Constant.TOPIC_EXCHANGE_QUEUE)
    public void receiveFromTopicExchange(OrderDto orderDto) {
        log.info("FromTopicExchange to queue {} : {}", Constant.TOPIC_EXCHANGE_QUEUE, orderDto);
    }

    // 3 receivers to demonstrate fanout exchange behaviour
    @RabbitListener(queues = Constant.FANOUT_EXCHANGE_QUEUE_1)
    public void receiveFromFanoutExchangeToReceiver1(OrderDto orderDto) {
        log.info("FromFanoutExchange to queue {} : {}", Constant.FANOUT_EXCHANGE_QUEUE_1, orderDto);
    }

    @RabbitListener(queues = Constant.FANOUT_EXCHANGE_QUEUE_2)
    public void receiveFromFanoutExchangeToReceiver2(OrderDto orderDto) {
        log.info("FromFanoutExchange to queue {} : {}", Constant.FANOUT_EXCHANGE_QUEUE_2, orderDto);
    }

    @RabbitListener(queues = Constant.FANOUT_EXCHANGE_QUEUE_3)
    public void receiveFromFanoutExchangeToReceiver3(OrderDto orderDto) {
        log.info("FromFanoutExchange to queue {} : {}", Constant.FANOUT_EXCHANGE_QUEUE_3, orderDto);
    }
}
