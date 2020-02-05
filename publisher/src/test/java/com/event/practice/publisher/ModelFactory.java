package com.event.practice.publisher;

import com.event.practice.common.dto.OrderDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ModelFactory {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public OrderDto getOrderDto() {
        return objectMapper.readValue("{\n" +
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
                "}", OrderDto.class);
    }
}
