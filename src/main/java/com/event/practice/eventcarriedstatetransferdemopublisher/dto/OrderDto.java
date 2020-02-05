package com.event.practice.eventcarriedstatetransferdemopublisher.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class OrderDto {
    private String orderId;
    private List<ProductDto> products;
    private UserDto receipient;
}
