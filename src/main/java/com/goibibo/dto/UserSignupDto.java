package com.goibibo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String city;

    private String country;

    private String postalCode;

}