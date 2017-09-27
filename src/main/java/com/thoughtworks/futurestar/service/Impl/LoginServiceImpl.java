package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.cache.SessionCache;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionCache sessionCache;

    @Override
    public boolean isValid(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user.getPassword().equals(password)) {
            sessionCache.setUser(user);
            return true;
        }
        return false;
    }
}
