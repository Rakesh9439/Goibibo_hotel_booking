package com.goibibo.service;

import com.goibibo.entity.UserSignup;

public interface JWTService {

    String generateToken(UserSignup userSignup);

    String getUsername(String token);
}
