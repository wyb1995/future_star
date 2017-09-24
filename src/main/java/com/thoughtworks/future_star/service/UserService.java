package com.thoughtworks.future_star.service;

import com.thoughtworks.future_star.dto.UserConfigDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class UserService {
    public static final AtomicLong id = new AtomicLong();
    public static Map<Integer, UserConfigDTO> userDataMap = new HashMap<>();

    public boolean createAccount(UserConfigDTO userConfigDTO) {
        int userId = (int) id.incrementAndGet();
        List<UserConfigDTO> list = userDataMap.values().stream()
                .filter(item -> item.getUsername().equals(userConfigDTO.getUsername()))
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            userDataMap.put(userId, userConfigDTO);
        }
        return list.isEmpty();
    }

    public List<UserConfigDTO> getUserList() {
        return new ArrayList<>(userDataMap.values());
    }

    public String updateUserAgeById(Integer id, Integer age) {
        if(userDataMap.containsKey(id)){
            UserConfigDTO userConfigDTO = userDataMap.get(id);

            userConfigDTO.setAge(age);

            userDataMap.replace(id, userConfigDTO);

            return userDataMap.get(id).toString();
        }
        return null;
    }

    public List<UserConfigDTO> findUserByAge(Integer age) {
        return UserService.userDataMap.values().stream()
                .filter(item -> Objects.equals(item.getAge(), age))
                .collect(Collectors.toList());
    }
}
