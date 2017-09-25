package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.entity.User;

import java.util.List;

public interface UserService {
    void createAccount(User user);

    List<User> getUserList();

    String updateUserAgeById(Integer id, Integer age);

    List<User> findUserByAge(Integer age);
}
