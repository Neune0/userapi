package com.example.userapi.service;

import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}