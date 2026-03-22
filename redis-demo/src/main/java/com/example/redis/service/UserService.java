package com.example.redis.service;

import com.example.redis.model.User;
import com.example.redis.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User getUser(Long id) {

        // 1. Check Redis
        User user = repo.findById(id);

        if (user != null) {
            System.out.println("✅ From Redis Cache");
            return user;
        }

        // 2. Simulate DB call
        System.out.println("❌ From DB");
        user = new User(id, "Amey"); // ✅ this id must come from method parameter

        // 3. Save in Redis
        repo.save(user);

        return user;
    }
}