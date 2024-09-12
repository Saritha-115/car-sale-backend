package com.example.sithum_car_sale_user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_login")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
}
