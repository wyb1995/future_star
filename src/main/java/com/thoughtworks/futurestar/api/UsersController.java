package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    public Collection<User> userList() {
        return userService.getList();
    }

    @PutMapping(value = "/{id}/age/{age}")
    public String updateAge(@PathVariable("id") Integer id, @PathVariable("age") Integer age) {
        String userInfo = userService.updateUserAgeById(id, age);
        return userInfo != null ? "update you info success" : "update you info error";
    }

    @GetMapping(params = "age")
    public List<User> findUserByAge(@RequestParam("age") Integer age) {
        return userService.findUserByAge(age);
    }
}
