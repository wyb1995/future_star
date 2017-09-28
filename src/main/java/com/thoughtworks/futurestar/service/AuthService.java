package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.JWTUser;
import com.thoughtworks.futurestar.dto.LoginDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
    void logout(HttpServletRequest authorization);

    JWTUser getAuthorizedJWTUser(HttpServletRequest request);

    boolean hasJWTToken(HttpServletRequest request);

    JWTUser login(HttpServletResponse response, LoginDTO loginRequestUser);

}
