package com.event.practice.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ProductDto implements Serializable {
    private static final long serialVersionUID = -6564443368386884956L;

    private String name;
    private double price;
}
