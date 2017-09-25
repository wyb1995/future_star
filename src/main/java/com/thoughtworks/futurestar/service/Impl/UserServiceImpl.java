package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createAccount(User user) {
        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
    }

    @Override
    public List<User> getUserList() {
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
}
