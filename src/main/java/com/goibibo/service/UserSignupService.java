package com.goibibo.service;

import com.goibibo.dto.LoginDto;
import com.goibibo.dto.UserSignupDto;
import com.goibibo.entity.UserSignup;

public interface UserSignupService {

   UserSignup createUserSignup(UserSignupDto userSignupDto);

   String verifyLogin(LoginDto loginDto);
}
