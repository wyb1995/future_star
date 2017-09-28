package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.dto.JWTUser;
import com.thoughtworks.futurestar.dto.LoginDTO;
import com.thoughtworks.futurestar.service.AuthService;
import com.thoughtworks.futurestar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthService authService;

    @PostMapping
    public JWTUser login(@RequestBody LoginDTO loginData, HttpServletResponse response) {
//        if (loginService.isValid(loginData.getUsername(), loginData.getPassword())) {
//            return String.join(" ", loginData.getUsername(), "login successfully.");
//        }
//        throw new InvalidCredentialException("login error");
        return authService.login(response, loginData);
    }
}
