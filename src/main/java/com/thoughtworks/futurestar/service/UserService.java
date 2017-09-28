package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    User create(User user);

    List<User> getList();

    String updateUserAgeById(Integer id, Integer age);

    List<User> findUserByAge(Integer age);


}
