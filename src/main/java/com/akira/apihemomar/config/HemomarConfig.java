package com.akira.apihemomar.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HemomarConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
