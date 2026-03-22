package com.example.redis.repository;

import com.example.redis.model.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class UserRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    public UserRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static final String KEY = "USER";

    public void save(User user) {
        redisTemplate.opsForValue().set(KEY + user.getId(), user, 10, TimeUnit.MINUTES);
    }

    public User findById(Long id) {
        return (User) redisTemplate.opsForValue().get(KEY + id);
    }
}