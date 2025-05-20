package com.goibibo.controller;


import com.goibibo.dto.LoginDto;
import com.goibibo.dto.TokenResponse;
import com.goibibo.dto.UserSignupDto;
import com.goibibo.entity.UserSignup;
import com.goibibo.service.UserSignupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class UserSignupController {

    private UserSignupService userSignupService;


    public UserSignupController(UserSignupService userSignupService) {
        this.userSignupService = userSignupService;
    }

    // Endpoint for user signup
    // Base URL: localhost:8082/api/v1/signup

    @PostMapping("/signup")
    public ResponseEntity<String> signupUser(@RequestBody UserSignupDto userSignupDto) {
        UserSignup savedUser = userSignupService.createUserSignup(userSignupDto);
       if (savedUser!= null){
           return new ResponseEntity<>("Registration is successful", HttpStatus.CREATED);
       }
       return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }




    // Base URL: localhost:8082/api/v1/signup/getAllUserSignup

    @GetMapping("/getAllUserSignup")
    public ResponseEntity<List<UserSignupDto>> getAllUserSignup() {
        List<UserSignupDto> allUserSignup = userSignupService.getAllUserSignup();
        return new ResponseEntity<>(allUserSignup, HttpStatus.OK);
    }



          //      localhost:8082/api/v1/{id}/getAllUserSignup
        @GetMapping("/{id}/getAllUserSignupById")
     public ResponseEntity<UserSignupDto> getUserSignupById(@PathVariable Long id){
         UserSignupDto userSignupById = userSignupService.getUserSignupById(id);
                    return new ResponseEntity<>(userSignupById, HttpStatus.OK);
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
