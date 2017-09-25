package com.thoughtworks.future_star.api;

import com.thoughtworks.future_star.dto.LoginDataDTO;
import com.thoughtworks.future_star.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public String login(@RequestBody LoginDataDTO loginData){
        return loginService.login(loginData)? "login error" : String.join(" ", loginData.getUsername(), "login successfully.");
    }
}
