package com.goibibo.service;

import com.goibibo.dto.UserSignupDto;
import com.goibibo.entity.UserSignup;
import com.goibibo.repository.UserSignupRepository;
import org.springframework.stereotype.Service;

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
        userSignup.setPassword(userSignupDto.getPassword());
        userSignup.setCountry(userSignupDto.getCountry());
        userSignup.setCity(userSignupDto.getCity());
        userSignup.setAddress(userSignupDto.getAddress());
        userSignup.setPostalCode(userSignupDto.getPostalCode());
        userSignup.setPhone(userSignupDto.getPhone());

        //   Save the user signup entity
        UserSignup savedUserSignup = userSignupRepository.save(userSignup);
         return savedUserSignup;

    }


}
