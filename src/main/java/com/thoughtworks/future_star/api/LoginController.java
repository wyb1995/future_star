package com.thoughtworks.future_star.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @PostMapping
    public String login(@RequestBody UserData loginData){
        Map<Integer, UserData> userDataMap = UsersController.userDataMap;
        List<UserData> list = userDataMap.values().stream()
                .filter(item -> item.getPassword().equals(loginData.getPassword()) && item.getUsername().equals(loginData.getUsername()))
                .collect(Collectors.toList());

        return list.isEmpty() ? "login error" : "{" + loginData.getUsername() + "} login successful";
    }
}
