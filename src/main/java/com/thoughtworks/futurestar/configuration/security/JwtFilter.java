package com.thoughtworks.futurestar.configuration.security;

import com.thoughtworks.futurestar.dto.JWTUser;
import com.thoughtworks.futurestar.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter{

    @Autowired
    private AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!authService.hasJWTToken(request)) {
            doFilter(request, response, filterChain);
            return;
        }
        handleJWTFilter(request, response, filterChain);
    }

    private void handleJWTFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        JWTUser authorizedJWTUser = authService.getAuthorizedJWTUser(request);
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(authorizedJWTUser, null, authorizedJWTUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(token);

        doFilter(request, response, filterChain);
    }
}
