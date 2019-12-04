package com.example.microservice.limitservice.controller;

import com.example.microservice.limitservice.bean.LimitConfiguration;
import com.example.microservice.limitservice.component.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration getLimitConfig(){
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }
}
