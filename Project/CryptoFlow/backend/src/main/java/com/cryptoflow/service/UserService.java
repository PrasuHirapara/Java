package com.cryptoflow.service;

import com.cryptoflow.domain.VerificationType;
import com.cryptoflow.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User saveUser(User user);

    User findByEmail(String email);

    User findByJWT(String jwt) throws Exception;

    User findById(Long id) throws Exception;

    User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user);

    User updatePassword(User user, String newPassword);
}
