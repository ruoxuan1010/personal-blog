package com.example.personalblog.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    private String email;
}
