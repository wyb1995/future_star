package com.thoughtworks.future_star.api;

import com.thoughtworks.future_star.dto.UserConfigDTO;
import com.thoughtworks.future_star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody UserConfigDTO userConfigDTO) {
        boolean isCreated = userService.createAccount(userConfigDTO);
        System.out.println(isCreated ? "create success" : "create error");
        return isCreated ? "create success" : "create error";
    }

    @GetMapping
    public Collection<UserConfigDTO> userList() {
        return userService.getUserList();
    }

    @PutMapping(value = "/{id}/age/{age}")
    public String updateAge(@PathVariable("id") Integer id, @PathVariable("age") Integer age){
        String userInfo = userService.updateUserAgeById(id, age);
        return userInfo != null ? "update you info success" : "update you info error";
    }

    @GetMapping(params = "age")
    public List<UserConfigDTO> findUserByAge(@RequestParam("age") Integer age) {
        return userService.findUserByAge(age);
    }
}
