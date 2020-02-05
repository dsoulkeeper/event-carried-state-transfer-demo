package com.event.practice.eventcarriedstatetransferdemopublisher.rest;

import com.event.practice.eventcarriedstatetransferdemopublisher.AbstractIntegrationTest;
import com.event.practice.eventcarriedstatetransferdemopublisher.ModelFactory;
import com.event.practice.eventcarriedstatetransferdemopublisher.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.NO_CONTENT;

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
        OrderDto orderOrReceivedViaRabbitMq = rabbitMqTestReceiver.getOrderOrWait();

        // this assert is confirming that we got the message via rabbitMq
        assertThat(orderDto.getOrderId()).isEqualTo(orderOrReceivedViaRabbitMq.getOrderId());
    }
}
