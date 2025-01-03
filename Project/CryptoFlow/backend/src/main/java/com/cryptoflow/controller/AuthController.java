package com.cryptoflow.controller;

import com.cryptoflow.config.JwtProvider;
import com.cryptoflow.entity.User;
import com.cryptoflow.response.AuthResponse;
import com.cryptoflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> saveUser(@RequestBody User user) throws Exception {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User isEmailExist = userService.findByEmail(user.getEmail());
        if (isEmailExist != null) {
            throw new Exception("Email is already in use");
        }

        User savedUser = userService.saveUser(user);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = JwtProvider.generateToken(auth);

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("Success");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}