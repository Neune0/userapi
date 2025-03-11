package com.example.userapi.service;

import com.example.userapi.model.User;
import come.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    private final List<User> users = List.of(
        new User(1L, "Mario Rossi", "mario.rossi@example.com"),
        new User(2L, "Luigi Verdi", "luigi.verdi@example.com"),
        new User(3L, "Paolo Bianchi", "paolo.bianchi@example.com")
    );

    public List<User> getUsers(){
        return users;
    }

    public Optional<User> getUserById(Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public List<User> getUsersByName(String name){
        return users.stream()
        .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
}