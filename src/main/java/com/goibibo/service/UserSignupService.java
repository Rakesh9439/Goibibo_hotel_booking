package com.goibibo.service;

import com.goibibo.dto.LoginDto;
import com.goibibo.dto.UserSignupDto;
import com.goibibo.entity.UserSignup;

import java.util.List;

public interface UserSignupService {

   UserSignup createUserSignup(UserSignupDto userSignupDto);


   List<UserSignupDto> getAllUserSignup();

   UserSignupDto getUserSignupById(Long id);

   String verifyLogin(LoginDto loginDto);
}
