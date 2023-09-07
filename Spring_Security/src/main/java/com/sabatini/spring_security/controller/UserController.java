package com.sabatini.spring_security.controller;

import com.sabatini.spring_security.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> registerUser(User user) {
        return ResponseEntity.created(userService.registerUser(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(Long id, User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
