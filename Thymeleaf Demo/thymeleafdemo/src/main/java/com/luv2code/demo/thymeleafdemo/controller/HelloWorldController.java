package com.luv2code.demo.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree (@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();

        String result = "Yo! " + theName;

        model.addAttribute("message", result);
        return "helloworld";
    }
}
