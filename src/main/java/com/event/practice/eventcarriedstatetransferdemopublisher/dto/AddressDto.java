package com.event.practice.eventcarriedstatetransferdemopublisher.dto;

import lombok.Data;

@Data
public class AddressDto {
    private AddressType addressType;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
}
