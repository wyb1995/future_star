package com.thoughtworks.future_star.service;

import com.thoughtworks.future_star.dto.LoginDataDTO;
import com.thoughtworks.future_star.dto.UserConfigDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoginService {
    Map<Integer, UserConfigDTO> userDataMap = UserService.userDataMap;

    public Boolean login(LoginDataDTO loginData) {
        List<UserConfigDTO> list = userDataMap.values().stream()
                .filter(item -> item.getPassword().equals(loginData.getPassword()) && item.getUsername().equals(loginData.getUsername()))
                .collect(Collectors.toList());

        return list.isEmpty();
    }
}
