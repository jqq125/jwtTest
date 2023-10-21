package com.example.jwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code @author:kiki}
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
