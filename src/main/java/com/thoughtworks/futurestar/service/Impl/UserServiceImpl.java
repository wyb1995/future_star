package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.dto.JWTUser;
import com.thoughtworks.futurestar.entity.Privilege;
import com.thoughtworks.futurestar.entity.Role;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User create(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public String updateUserAgeById(Integer id, Integer age) {
        return null;
    }

    @Override
    public List<User> findUserByAge(Integer age) {
        return null;
    }

    @Override
    public JWTUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("not found");
        }
        Role role = user.getRole();
        return JWTUser.builder()
                .username(username)
                .password(user.getPassword())
                .role("")
                .privileges(Collections.EMPTY_LIST)
                .build();
    }
}
