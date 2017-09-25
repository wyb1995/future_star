package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.dto.LoginDataDTO;
import com.thoughtworks.futurestar.service.LoginService;
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
