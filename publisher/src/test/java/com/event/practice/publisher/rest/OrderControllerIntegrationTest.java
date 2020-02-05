package com.event.practice.publisher.rest;

import com.event.practice.publisher.AbstractIntegrationTest;
import com.event.practice.publisher.ModelFactory;
import com.event.practice.common.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@Slf4j
public class OrderControllerIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void shouldGetNoContentResponse() {
        // Arrange
        OrderDto orderDto = ModelFactory.getOrderDto();
        HttpEntity<OrderDto> httpEntity = new HttpEntity<>(orderDto);

        // Act
        ResponseEntity<Object> objectResponseEntity = testRestTemplate.postForEntity("/order", httpEntity, null, POST);

        // Assert
        assertThat(objectResponseEntity.getStatusCode()).isEqualTo(NO_CONTENT);

        // From topic exchange
        OrderDto orderFromTopicExchange = rabbitMqTestReceiver.fromTopicExchangeGetOrderOrWait();
        assertThat(orderDto.getOrderId()).isEqualTo(orderFromTopicExchange.getOrderId());
        log.info("orderFromTopicExchange passed");

        // From fanout exchange receiver 1
        OrderDto orderFromFanoutExchangeReceiver1 = rabbitMqTestReceiver.fromFanoutExchangeReceiver1GetOrderOrWait();
        assertThat(orderDto.getOrderId()).isEqualTo(orderFromFanoutExchangeReceiver1.getOrderId());
        log.info("orderFromFanoutExchangeReceiver1 passed");

        // From fanout exchange receiver 2
        OrderDto orderFromFanoutExchangeReceiver2 = rabbitMqTestReceiver.fromFanoutExchangeReceiver2GetOrderOrWait();
        assertThat(orderDto.getOrderId()).isEqualTo(orderFromFanoutExchangeReceiver2.getOrderId());
        log.info("orderFromFanoutExchangeReceiver2 passed");

        // From fanout exchange receiver 3
        OrderDto orderFromFanoutExchangeReceiver3 = rabbitMqTestReceiver.fromFanoutExchangeReceiver3GetOrderOrWait();
        assertThat(orderDto.getOrderId()).isEqualTo(orderFromFanoutExchangeReceiver3.getOrderId());
        log.info("orderFromFanoutExchangeReceiver3 passed");
    }
}
