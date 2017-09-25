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
    private UserService userServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody User user) {
        userServiceImpl.createAccount(user);
        return user.getUsername() + " create successful.";
    }

    @GetMapping
    public Collection<User> userList() {
        return userServiceImpl.getUserList();
    }

    @PutMapping(value = "/{id}/age/{age}")
    public String updateAge(@PathVariable("id") Integer id, @PathVariable("age") Integer age){
        String userInfo = userServiceImpl.updateUserAgeById(id, age);
        return userInfo != null ? "update you info success" : "update you info error";
    }

    @GetMapping(params = "age")
    public List<User> findUserByAge(@RequestParam("age") Integer age) {
        return userServiceImpl.findUserByAge(age);
    }
}
