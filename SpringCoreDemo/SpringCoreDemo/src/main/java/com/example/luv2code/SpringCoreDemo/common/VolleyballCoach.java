package com.example.luv2code.SpringCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach {
    public VolleyballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "Volleyball";
    }
}
