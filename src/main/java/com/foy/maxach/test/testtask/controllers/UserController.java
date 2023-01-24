package com.foy.maxach.test.testtask.controllers;

import com.foy.maxach.test.testtask.models.User;
import com.foy.maxach.test.testtask.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    public UserService userService;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable String id) {
        return userService.getById(id);
    }

}
