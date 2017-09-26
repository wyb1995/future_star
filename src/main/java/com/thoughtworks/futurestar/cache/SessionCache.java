package com.thoughtworks.futurestar.cache;

import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionCache {
    private User user;

    @Autowired
    private UserRepository userRepository;

    public void setUser(User user) {
        this.user = user;
    }

    public User loadCurrentUser() {
        if (user != null) {
            return user;
        }
        user = userRepository.findAll().get(0);
        return user;
    }
}
