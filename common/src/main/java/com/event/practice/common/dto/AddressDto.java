package com.event.practice.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private static final long serialVersionUID = -426602671809098312L;

    private AddressType addressType;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
}
