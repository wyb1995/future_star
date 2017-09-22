package com.thoughtworks.future_star.api;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    public static Map<Integer, UserData> userDataMap = new HashMap<>();
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

    @PutMapping(value = "/{id}/update", params = "age")
    public String updateAge(@PathVariable("id") Integer id, @RequestParam("age") Integer age){

        if (userDataMap.containsKey(id)) {
            UserData userData = userDataMap.get(id);

            userData.setAge(age);

            userDataMap.replace(id, userData);

            return "update you age to " + age;
        }
        return "update you age error";
    }
}
