package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.StringUtils;
import com.thoughtworks.futurestar.dto.JWTUser;
import com.thoughtworks.futurestar.dto.LoginDTO;
import com.thoughtworks.futurestar.exception.InvalidCredentialException;
import com.thoughtworks.futurestar.repository.TokenAuthRepository;
import com.thoughtworks.futurestar.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    private static final String PREFIX_BLACK_LIST = "SSJ-BLACKLIST-";

    @Value("${security.jwt.token-prefix:Bearer}")
    private String tokenPrefix;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.expiration-in-seconds}")
    private long expirationInSeconds;

    @Autowired
    private TokenAuthRepository authRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public JWTUser login(HttpServletResponse response, LoginDTO loginRequestUser) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestUser.getUsername(), loginRequestUser.getPassword()));
        JWTUser principal = (JWTUser) authenticate.getPrincipal();

        Map payload = StringUtils.readJsonStringAsObject(StringUtils.writeObjectAsJsonString(principal), Map.class);

        response.addHeader(header, String.join(" ", tokenPrefix,
                authRepository.generateToken(payload)));
        return principal;
    }

    @Override
    public void logout(HttpServletRequest request) {
        String token = extractToken(request);
        String key = PREFIX_BLACK_LIST + token;
    }

    @Override
    public JWTUser getAuthorizedJWTUser(HttpServletRequest request) {
        String payload = authRepository.extractAuthorizedPayload(extractToken(request));
        return StringUtils.readJsonStringAsObject(payload, JWTUser.class);
    }

    @Override
    public boolean hasJWTToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(header);
        return StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith(tokenPrefix);
    }

//    @Override
//    public boolean isTokenInBlackList(HttpServletRequest request) {
//        String token = extractToken(request);
//    }

    private String extractToken(HttpServletRequest request) {
        if (!hasJWTToken(request)) {
            throw new InvalidCredentialException();
        }
        return request.getHeader(header).substring(tokenPrefix.length() + 1);
    }
}
