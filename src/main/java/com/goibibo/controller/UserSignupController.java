package com.goibibo.controller;


import com.goibibo.dto.LoginDto;
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
    public ResponseEntity<UserSignup> signupUser(@RequestBody UserSignupDto userSignupDto) {
        UserSignup savedUser = userSignupService.createUserSignup(userSignupDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);  // 201 CREATED
    }




    @PostMapping("/login")
    public ResponseEntity<String> verifyLogin(@RequestBody LoginDto loginDto) {
        String message = userSignupService.verifyLogin(loginDto);
        return ResponseEntity.ok(message);  // Always returning 200 OK with message
    }

}
