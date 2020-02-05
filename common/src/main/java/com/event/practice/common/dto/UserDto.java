package com.event.practice.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class UserDto implements Serializable {
    private static final long serialVersionUID = 2472700282127732485L;

    private UserProfileDto basicProfile;
    private List<AddressDto> addresses;
}
