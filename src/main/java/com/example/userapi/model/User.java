package com.example.userapi.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=50)
    private String name;

    @Column(nullable = false, unique=true)
    private String email;

    public User(){
    }

    public User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
}
