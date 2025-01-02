package com.cryptoflow.service;

import com.cryptoflow.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User saveUser(User user);

    User findByEmail(String email);
}
