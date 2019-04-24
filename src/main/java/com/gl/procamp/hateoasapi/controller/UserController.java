package com.gl.procamp.hateoasapi.controller;

import com.gl.procamp.hateoasapi.entity.User;
import com.gl.procamp.hateoasapi.service.UserService;
import com.gl.procamp.hateoasapi.util.UserResource;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<UserResource> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public UserResource getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PutMapping("{id}/changeState")
    public UserResource setUserState(@PathVariable("id") Integer id) {
        return userService.changeStatus(id);
    }

}
