package com.cryptoflow.controller;

import com.cryptoflow.domain.VerificationType;
import com.cryptoflow.entity.User;
import com.cryptoflow.entity.VerificationCode;
import com.cryptoflow.service.EmailService;
import com.cryptoflow.service.UserService;
import com.cryptoflow.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private VerificationCodeService verificationCodeService;

    @Autowired
    private EmailService emailService;

    @GetMapping("api/users/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByJWT(jwt);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/api/users/verification/{verificationType}/send-otp")
    public ResponseEntity<String> sendVerificationOtp(
            @RequestHeader("Authorization") String jwt,
            @PathVariable VerificationType verificationType
    ) throws Exception {
        User user = userService.findByJWT(jwt);

        VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUser(user.getId());

        if (verificationCode == null) {
            verificationCode = verificationCodeService.sendVerificationCode(user, verificationType);
        }

        if(verificationType.equals(VerificationType.EMAIL)) {
            emailService.sendVerificationOtpMail(user.getEmail(), verificationCode.getOtp());
        } else if (verificationType.equals(VerificationType.MOBILE)) {
            // Implement sending OTP for phone (SMS, etc.) if needed
        }

        return new ResponseEntity<>("Verification OTP sent.", HttpStatus.OK);
    }

    @PatchMapping("/api/users/enable-two-factor/verify-otp/{otp}")
    public ResponseEntity<User> enableTwoFactorAuthentication(
            @PathVariable String otp,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user = userService.findByJWT(jwt);

        VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUser(user.getId());

        String sendTo = verificationCode.getVerificationType().equals(VerificationType.EMAIL)
                ? verificationCode.getEmail()
                : verificationCode.getOtp();

        boolean isVerified = verificationCode.getOtp().equals(otp);

        if (isVerified) {
            User updated = userService.enableTwoFactorAuthentication(verificationCode.getVerificationType(), sendTo, user);

            // Delete the verification code after successful verification
            verificationCodeService.deleteVerificationCodeById(verificationCode);

            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

        throw new Exception("Wrong OTP");
    }
}
