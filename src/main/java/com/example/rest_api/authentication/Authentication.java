package com.example.rest_api.authentication;

import com.example.rest_api.repository.StudentRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpClient;

@Configuration
public class Authentication {

    private final StudentRepo studentRepo;

    public Authentication(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/student/**").permitAll()  // Allow access to /api/student/*
                        .anyRequest().authenticated()  // Authenticate other requests
                )
                .formLogin(Customizer.withDefaults())  // Default form login
                .httpBasic(Customizer.withDefaults()); // Optional basic authentication
        return http.build();
    }
}
