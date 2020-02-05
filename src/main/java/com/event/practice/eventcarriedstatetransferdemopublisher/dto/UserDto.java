package com.event.practice.eventcarriedstatetransferdemopublisher.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserDto {
    private UserProfileDto basicProfile;
    private List<AddressDto> addresses;
}
