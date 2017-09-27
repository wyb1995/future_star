package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.dto.LoginDTO;
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
    private LoginService loginService;

    @PostMapping
    public String login(@RequestBody LoginDTO loginData) {
        if (loginService.isValid(loginData.getUsername(), loginData.getPassword())) {
            return String.join(" ", loginData.getUsername(), "login successfully.");
        }
        throw new InvalidCredentialException("login error");
    }
}
