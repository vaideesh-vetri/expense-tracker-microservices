package com.expensetracker.auth_service.service;

import com.expensetracker.auth_service.dto.RegisterRequest;
import com.expensetracker.auth_service.entity.User;
import com.expensetracker.auth_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository=repository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request){
        if(repository.existsByEmail(request.getEmail())){
            return "Email Already Exist";
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        repository.save(user);

        return "User Registered Successfully";
    }
}
