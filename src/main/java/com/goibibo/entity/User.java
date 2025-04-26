package com.goibibo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 155)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 155)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true, length = 155)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, unique = true, length = 155)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false, length = 155)
    private String city;

    @Column(name = "country", nullable = false, length = 155)
    private String country;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

}