package com.event.practice.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserProfileDto implements Serializable {
    private static final long serialVersionUID = 7507239416600145988L;

    private String name;
    private String phoneNumber;
    private String email;
}
