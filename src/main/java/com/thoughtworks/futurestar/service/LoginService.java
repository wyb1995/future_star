package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.LoginDataDTO;
import com.thoughtworks.futurestar.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoginService {
    Map<Integer, User> userDataMap = UserService1.userDataMap;

    public Boolean login(LoginDataDTO loginData) {
        List<User> list = userDataMap.values().stream()
                .filter(item -> item.getPassword().equals(loginData.getPassword()) && item.getUsername().equals(loginData.getUsername()))
                .collect(Collectors.toList());

        return list.isEmpty();
    }
}
