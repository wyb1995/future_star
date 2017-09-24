package com.thoughtworks.future_star.api;

import com.thoughtworks.future_star.dto.UserConfigDTO;
import com.thoughtworks.future_star.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public String login(@RequestBody UserConfigDTO loginData){
        return loginService.login(loginData)? "login error" : String.join(" ", loginData.getUsername(), "login successfully.");
    }
}
