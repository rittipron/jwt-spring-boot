package com.example.jwt_spring_boot.controller;

import com.example.jwt_spring_boot.service.UserDetailsImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@Log4j2
public class TestController {
    @GetMapping("/all")
    public String allAccess() { return "Public Content."; }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public  String userAccess() { return "User Content."; }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public  String moderatorAccess() { return "User Content."; }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public  String adminAccess() { return "Admin Board."; }

    @GetMapping("/prodile")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public UserDetailsImpl profile() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        log.info("username: {}", userDetails.getUsername());
        return userDetails;
    }
}
