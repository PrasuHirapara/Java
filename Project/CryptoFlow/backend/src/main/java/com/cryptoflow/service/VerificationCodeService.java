package com.cryptoflow.service;

import com.cryptoflow.domain.VerificationType;
import com.cryptoflow.entity.User;
import com.cryptoflow.entity.VerificationCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface VerificationCodeService {

    VerificationCode sendVerificationCode(User user, VerificationType verificationType);

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationCodeByUser(Long id);

    void deleteVerificationCodeById(VerificationCode verificationCode);
}

