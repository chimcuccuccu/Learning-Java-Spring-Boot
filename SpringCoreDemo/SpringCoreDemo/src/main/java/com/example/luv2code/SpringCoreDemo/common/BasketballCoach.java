package com.example.luv2code.SpringCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {
    public BasketballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "Basketball";
    }
}
