package com.example.userapi.controller;

import com.example.userapi.model.User;
import com.example.userapi.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
public class UserController{
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<User> getUsersByName(@RequestParam String name){
        return userService.getUsersByName(name);
    }

    @PostMapping
    public ResponseEntity<User> postMethodName(@RequestBody User user) {
        // add user
        User userCreated = userService.addUser(user);
        // redirect to the created user
        URI location = URI.create(String.format("/api/users/%d", userCreated.getId()));
        // return the created user in the response body and the location in the header
        return ResponseEntity.created(location).body(userCreated);
    }
    
}