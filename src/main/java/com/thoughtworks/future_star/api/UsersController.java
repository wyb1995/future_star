package com.thoughtworks.future_star.api;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    public Map<Integer, UserData> userDataMap = new HashMap<>();
    private final AtomicLong id = new AtomicLong();

    @PostMapping
    public String create(@RequestBody UserData userData) {
        userDataMap.put((int) id.incrementAndGet(), userData);
        return "create success";
    }

    @GetMapping
    public Collection<UserData> userList() {
        return userDataMap.values();
    }
}
