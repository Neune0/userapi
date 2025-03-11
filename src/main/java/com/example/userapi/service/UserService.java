package com.example.userapi.service;

import com.example.userapi.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final ArrayList<User> users = new ArrayList<>(List.of(
        new User(1L, "Mario Rossi", "mario.rossi@example.com"),
        new User(2L, "Luigi Verdi", "luigi.verdi@example.com"),
        new User(3L, "Paolo Bianchi", "paolo.bianchi@example.com")
    ));

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

    public User addUser(User user){
        users.add(user);
        return user;
    }
}