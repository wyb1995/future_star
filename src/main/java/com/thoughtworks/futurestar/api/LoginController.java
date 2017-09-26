package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.dto.LoginDataDTO;
import com.thoughtworks.futurestar.exception.InvalidCredentialException;
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
    private LoginService loginServiceImpl;

    @PostMapping
    public String login(@RequestBody LoginDataDTO loginData) {
        if (loginServiceImpl.isValid(loginData.getUsername(), loginData.getPassword())) {
            return String.join(" ", loginData.getUsername(), "login successfully.");
        }
        throw new InvalidCredentialException("login error");
    }
}
