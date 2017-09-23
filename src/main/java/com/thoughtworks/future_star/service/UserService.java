package com.thoughtworks.future_star.service;

import com.thoughtworks.future_star.dto.UserConfigDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class UserService {
    public static final AtomicLong id = new AtomicLong();
    public static Map<Integer, UserConfigDTO> userDataMap = new HashMap<>();

    public boolean createAccount(UserConfigDTO userConfigDTO) {
        int userId = (int) id.incrementAndGet();
        userDataMap.put(userId, userConfigDTO);
        return userDataMap.containsKey(userId);
    }

    public List<UserConfigDTO> getUserList() {
        return new ArrayList<>(userDataMap.values());
    }
}
