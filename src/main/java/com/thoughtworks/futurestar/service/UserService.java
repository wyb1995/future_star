package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface UserService {
    void createAccount(User user);

    List<User> getUserList();

    String updateUserAgeById(Integer id, Integer age);

    List<User> findUserByAge(Integer age);
}
