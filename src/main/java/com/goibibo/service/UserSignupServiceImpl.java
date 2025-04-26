package com.goibibo.service;

import com.goibibo.dto.LoginDto;
import com.goibibo.dto.UserSignupDto;
import com.goibibo.entity.UserSignup;
import com.goibibo.repository.UserSignupRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSignupServiceImpl implements UserSignupService{
    
    
    private UserSignupRepository userSignupRepository;

    public UserSignupServiceImpl(UserSignupRepository userSignupRepository) {
        this.userSignupRepository = userSignupRepository;
    }

    @Override
    public UserSignup createUserSignup(UserSignupDto userSignupDto) {

        // Convert UserSignupDto to UserSignup entity
        UserSignup userSignup = new UserSignup();
        userSignup.setFirstName(userSignupDto.getFirstName());
        userSignup.setLastName(userSignupDto.getLastName());
        userSignup.setUsername(userSignupDto.getUsername());
        userSignup.setEmail(userSignupDto.getEmail());
        userSignup.setPassword(BCrypt.hashpw(userSignupDto.getPassword(), BCrypt.gensalt(10)));
        userSignup.setCountry(userSignupDto.getCountry());
        userSignup.setCity(userSignupDto.getCity());
        userSignup.setAddress(userSignupDto.getAddress());
        userSignup.setPostalCode(userSignupDto.getPostalCode());
        userSignup.setPhone(userSignupDto.getPhone());

        //   Save the user signup entity
        UserSignup savedUserSignup = userSignupRepository.save(userSignup);
         return savedUserSignup;

    }


        // Login verving
        public String verifyLogin(LoginDto loginDto){
            Optional<UserSignup> opSuser = userSignupRepository.findByUsername(loginDto.getUsername());
            if (opSuser.isPresent()) {
                UserSignup userSignup = opSuser.get();

                // Compare passwords
                if (userSignup.getPassword().equals(loginDto.getPassword())) {
                    return "✅ User logged in successfully!";
                } else {
                    return "❌ Incorrect password!";
                }
            }else {
                return "❌ Username not found!";
            }



            }


        }



