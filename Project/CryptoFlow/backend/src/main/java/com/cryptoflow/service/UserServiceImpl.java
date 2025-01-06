package com.cryptoflow.service;

import com.cryptoflow.config.JwtProvider;
import com.cryptoflow.domain.VerificationType;
import com.cryptoflow.entity.User;
import com.cryptoflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByJWT(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromToken(jwt);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new Exception("User not found.");
        }

        return user;
    }

    @Override
    public User findById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        throw new Exception("User not found.");
    }

    @Override
    public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user) {
        return null;
    }

    @Override
    public User updatePassword(String oldPassword, String newPassword) {
        return null;
    }
}
