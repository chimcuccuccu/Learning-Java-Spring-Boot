package com.example.luv2code.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("In constructor(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "Swim 1000 meters as a warm up";
    }
}
