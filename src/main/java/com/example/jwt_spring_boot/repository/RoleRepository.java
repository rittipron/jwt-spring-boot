package com.example.jwt_spring_boot.repository;

import com.example.jwt_spring_boot.model.ERole;
import com.example.jwt_spring_boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
