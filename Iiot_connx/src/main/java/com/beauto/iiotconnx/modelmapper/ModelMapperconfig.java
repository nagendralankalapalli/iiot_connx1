package com.beauto.iiotconnx.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperconfig {
 
//    @Bean
//    public UserServiceImpl employeeBean() {
//        return new UserServiceImpl();
//    }
 
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
 
}
