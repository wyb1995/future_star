package com.thoughtworks.future_star.api;

import com.thoughtworks.future_star.dto.UserConfigDTO;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    public static Map<Integer, UserConfigDTO> userDataMap = new HashMap<>();
    private final AtomicLong id = new AtomicLong();

    @PostMapping
    public String create(@RequestBody UserConfigDTO userConfigDTO) {
        userDataMap.put((int) id.incrementAndGet(), userConfigDTO);
        return "create success";
    }

    @GetMapping
    public Collection<UserConfigDTO> userList() {
        return userDataMap.values();
    }

    @PutMapping(value = "/{id}/{age}")
    public String updateAge(@PathVariable("id") Integer id, @PathVariable("age") Integer age){

        if (userDataMap.containsKey(id)) {
            UserConfigDTO userConfigDTO = userDataMap.get(id);

            userConfigDTO.setAge(age);

            userDataMap.replace(id, userConfigDTO);

            return "update you age to " + age;
        }
        return "update you age error";
    }

    @GetMapping(params = "age")
    public List<UserConfigDTO> findUserByAge(@RequestParam("age") Integer age) {

        return userDataMap.values().stream()
                .filter(item -> Objects.equals(item.getAge(), age))
                .collect(Collectors.toList());
    }
}
