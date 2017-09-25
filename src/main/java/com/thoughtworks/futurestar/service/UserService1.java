package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class UserService1 {
    public static final AtomicLong id = new AtomicLong();
    public static Map<Integer, User> userDataMap = new HashMap<>();

    public boolean createAccount(User user) {
        int userId = (int) id.incrementAndGet();
        List<User> list = userDataMap.values().stream()
                .filter(item -> item.getUsername().equals(user.getUsername()))
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            userDataMap.put(userId, user);
        }
        return list.isEmpty();
    }

    public List<User> getUserList() {
        return new ArrayList<>(userDataMap.values());
    }

    public String updateUserAgeById(Integer id, Integer age) {
        if(userDataMap.containsKey(id)){
            User user = userDataMap.get(id);

            user.setAge(age);

            userDataMap.replace(id, user);

            return userDataMap.get(id).toString();
        }
        return null;
    }

    public List<User> findUserByAge(Integer age) {
        return UserService1.userDataMap.values().stream()
                .filter(item -> Objects.equals(item.getAge(), age))
                .collect(Collectors.toList());
    }
}
