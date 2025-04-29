package com.goibibo.service.impl;

import com.goibibo.dto.LoginDto;
import com.goibibo.dto.UserSignupDto;
import com.goibibo.entity.UserSignup;
import com.goibibo.exception.ResourceNotFoundException;
import com.goibibo.repository.UserSignupRepository;
import com.goibibo.service.JWTService;
import com.goibibo.service.UserSignupMapper;
import com.goibibo.service.UserSignupService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserSignupServiceImpl implements UserSignupService {
    
    
    private UserSignupRepository userSignupRepository;
    private JWTService jwtService;
    private UserSignupMapper userSignupMapper;



    public UserSignupServiceImpl(UserSignupRepository userSignupRepository, JWTService jwtService, ModelMapper modelMapper, UserSignupMapper userSignupMapper) {
        this.userSignupRepository = userSignupRepository;
        this.jwtService = jwtService;

        this.userSignupMapper = userSignupMapper;
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
        userSignup.setUserRole(userSignupDto.getUserRole());

        //   Save the user signup entity
        UserSignup savedUserSignup = userSignupRepository.save(userSignup);
         return savedUserSignup;

    }

    @Override
    public List<UserSignupDto> getAllUserSignup() {
        List<UserSignup>  allUser = userSignupRepository.findAll();
        List<UserSignupDto> getAllUser = allUser.stream()
                .map(userSignupMapper::mapToDto).collect(Collectors.toList());
        return getAllUser;
    }

    @Override
    public UserSignupDto getUserSignupById(Long id) {
        Optional<UserSignup> userSignup = userSignupRepository.findById(id);
        if (userSignup.isEmpty()){
            throw new RuntimeException("User not found with id: " + id);
        }
        UserSignupDto userSignupDto = userSignupMapper.mapToDto(userSignup.get());


        return userSignupDto;
    }

    @Override

    public String verifyLogin(LoginDto loginDto) {
        Optional<UserSignup> opUser = userSignupRepository.findByUsername(loginDto.getUsername());
        if (opUser.isPresent()){
            UserSignup userSignup = opUser.get();
            if (BCrypt.checkpw(loginDto.getPassword(), userSignup.getPassword())){
                return jwtService.generateToken(userSignup);
            }
        }
        return null;
    }

        }



