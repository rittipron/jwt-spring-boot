package com.example.jwt_spring_boot.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column
    private ERole name;

}
