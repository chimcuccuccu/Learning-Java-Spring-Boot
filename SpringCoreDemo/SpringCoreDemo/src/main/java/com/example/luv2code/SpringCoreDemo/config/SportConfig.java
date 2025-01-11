package com.example.luv2code.SpringCoreDemo.config;

import com.example.luv2code.SpringCoreDemo.common.Coach;
import com.example.luv2code.SpringCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
