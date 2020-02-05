package com.event.practice.common.dto;

import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderDtoParseTest {

    @Test
    public void shouldParseJsonCorrectly() throws IOException {
        // Arrange
        String json = "{\n" +
                "\t\"orderId\": \"adfafdafafdasfas\",\n" +
                "\t\"products\": [{\n" +
                "\t\t\t\"name\": \"abc\",\n" +
                "\t\t\t\"price\": 1010\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"name\": \"abc1\",\n" +
                "\t\t\t\"price\": 10101\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"receipient\": {\n" +
                "\t\t\"basicProfile\": {\n" +
                "\t\t\t\"name\": \"somename\",\n" +
                "\t\t\t\"phoneNumber\": \"\",\n" +
                "\t\t\t\"email\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"addresses\": [{\n" +
                "\t\t\t\"addressType\": \"billing\",\n" +
                "\t\t\t\"line1\": \"\",\n" +
                "\t\t\t\"line2\": \"\",\n" +
                "\t\t\t\"city\": \"\",\n" +
                "\t\t\t\"state\": \"\",\n" +
                "\t\t\t\"country\": \"\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"addressType\": \"delivery\",\n" +
                "\t\t\t\"line1\": \"\",\n" +
                "\t\t\t\"line2\": \"\",\n" +
                "\t\t\t\"city\": \"\",\n" +
                "\t\t\t\"state\": \"\",\n" +
                "\t\t\t\"country\": \"\"\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();

        // Act
        OrderDto orderDto = objectMapper.readValue(json, OrderDto.class);

        // Assert
        assertThat(orderDto.getOrderId()).isEqualTo("adfafdafafdasfas");
        assertThat(orderDto.getProducts().get(0).getName()).isEqualTo("abc");

        assertThat(orderDto.getReceipient().getBasicProfile().getName()).isEqualTo("somename");
        assertThat(orderDto.getReceipient().getAddresses().get(0).getAddressType()).isEqualTo(AddressType.billing);

    }
}
