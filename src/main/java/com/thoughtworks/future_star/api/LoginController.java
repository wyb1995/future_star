package com.thoughtworks.future_star.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @PostMapping
    public String login(@RequestBody UserData loginData){
        if ("12345".equals(loginData.getPassword()) && "future_star".equals(loginData.getUsername())) {
            return "{" + loginData.getUsername() + "} login successful";
        }
        return "login error";
    }
}
