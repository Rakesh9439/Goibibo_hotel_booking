package com.goibibo.controller;


import com.goibibo.dto.LoginDto;
import com.goibibo.dto.TokenResponse;
import com.goibibo.dto.UserSignupDto;
import com.goibibo.entity.UserSignup;
import com.goibibo.service.UserSignupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class UserSignupController {

    private UserSignupService userSignupService;


    public UserSignupController(UserSignupService userSignupService) {
        this.userSignupService = userSignupService;
    }

    // Endpoint for user signup
    // Base URL: localhost:8082/api/signup

    @PostMapping("/signup")
    public ResponseEntity<String> signupUser(@RequestBody UserSignupDto userSignupDto) {
        UserSignup savedUser = userSignupService.createUserSignup(userSignupDto);
       if (savedUser!= null){
           return new ResponseEntity<>("Registration is successful", HttpStatus.CREATED);
       }
       return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }




    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        String token = userSignupService.verifyLogin(loginDto);
        if (token!= null){
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(token);
            return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid crdentials", HttpStatus.UNAUTHORIZED);
    }

    }
