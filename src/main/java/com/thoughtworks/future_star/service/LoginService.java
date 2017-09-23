package com.thoughtworks.future_star.service;

import com.thoughtworks.future_star.api.UserData;
import com.thoughtworks.future_star.api.UsersController;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoginService {
    Map<Integer, UserData> userDataMap = UsersController.userDataMap;

    public Boolean login(UserData loginData) {
        List<UserData> list = userDataMap.values().stream()
                .filter(item -> item.getPassword().equals(loginData.getPassword()) && item.getUsername().equals(loginData.getUsername()))
                .collect(Collectors.toList());

        return list.isEmpty();
    }
}
