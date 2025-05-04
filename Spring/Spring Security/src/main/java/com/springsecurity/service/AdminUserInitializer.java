package com.springsecurity.service;

import com.springsecurity.entity.Users;
import com.springsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitializer {

    @Bean
    public CommandLineRunner createAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                Users user = new Users();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin"));
                user.setRole("ROLE_ADMIN");

                userRepository.save(user);
                System.out.println("Default Admin user created");
            }
        };
    }
}
