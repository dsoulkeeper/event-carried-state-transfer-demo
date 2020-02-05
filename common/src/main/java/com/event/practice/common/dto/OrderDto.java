package com.event.practice.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class OrderDto implements Serializable {
    private static final long serialVersionUID = 6679117878003236015L;

    private String orderId;
    private List<ProductDto> products;
    private UserDto receipient;
}
