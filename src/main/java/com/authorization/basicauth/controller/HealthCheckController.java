package com.authorization.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basicauth/health")
public class HealthCheckController {

    @GetMapping("/status")
    public String healthStatus(){
        return "Application is up and Running";
    }
}
