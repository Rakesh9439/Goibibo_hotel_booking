package com.goibibo.config;


import com.goibibo.dto.UserSignupDto;
import com.goibibo.entity.UserSignup;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }



}
