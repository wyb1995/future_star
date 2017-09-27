package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> getList();

    String updateUserAgeById(Integer id, Integer age);

    List<User> findUserByAge(Integer age);
}
