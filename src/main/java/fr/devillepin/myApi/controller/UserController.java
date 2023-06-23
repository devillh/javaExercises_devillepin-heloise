package fr.devillepin.myApi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.devillepin.myApi.model.User;
import fr.devillepin.myApi.service.UserService;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam int id) {
        User user = userService.getUser(id);
        return user;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest body) {
        String name = body.getName();
        int age = body.getAge();
        User user = userService.createUser(name, age);

        return user;
    }

    @PutMapping("/user")
    public User updateUser(@RequestParam int id, @RequestBody UserRequest body) {
        User user = userService.updateUser(id, body.getName(), body.getAge());

        return user;
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestParam int id) {
        User user = userService.deleteUser(id);

        return user;
    }
}
