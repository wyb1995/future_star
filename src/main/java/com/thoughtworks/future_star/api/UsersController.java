package com.thoughtworks.future_star.api;

import com.thoughtworks.future_star.dto.UserConfigDTO;
import com.thoughtworks.future_star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String create(@RequestBody UserConfigDTO userConfigDTO) {
        boolean isCreated = userService.createAccount(userConfigDTO);
        return isCreated ? "create success" : "create error";
    }

    @GetMapping
    public Collection<UserConfigDTO> userList() {
        return UserService.userDataMap.values();
    }

    @PutMapping(value = "/{id}/{age}")
    public String updateAge(@PathVariable("id") Integer id, @PathVariable("age") Integer age){

        if (UserService.userDataMap.containsKey(id)) {
            UserConfigDTO userConfigDTO = UserService.userDataMap.get(id);

            userConfigDTO.setAge(age);

            UserService.userDataMap.replace(id, userConfigDTO);

            return "update you age to " + age;
        }
        return "update you age error";
    }

    @GetMapping(params = "age")
    public List<UserConfigDTO> findUserByAge(@RequestParam("age") Integer age) {

        return UserService.userDataMap.values().stream()
                .filter(item -> Objects.equals(item.getAge(), age))
                .collect(Collectors.toList());
    }
}
