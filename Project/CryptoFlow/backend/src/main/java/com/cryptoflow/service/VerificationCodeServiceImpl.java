package com.cryptoflow.service;

import com.cryptoflow.domain.VerificationType;
import com.cryptoflow.entity.User;
import com.cryptoflow.entity.VerificationCode;
import com.cryptoflow.repository.VerificationCodeRepository;
import com.cryptoflow.utils.OTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;


    @Override
    public VerificationCode sendVerificationCode(User user, VerificationType verificationType) {
        VerificationCode verificationCode1 = new VerificationCode();
        verificationCode1.setOtp(OTPUtils.generateOTP());
        verificationCode1.setUser(user);
        verificationCode1.setVerificationType(verificationType);

        verificationCodeRepository.save(verificationCode1);

        return verificationCode1;
    }

    @Override
    public VerificationCode getVerificationCodeById(Long id) throws Exception {
        Optional<VerificationCode> verificationCodeOptional = verificationCodeRepository.findById(id);

        if (verificationCodeOptional.isPresent()) {
            return verificationCodeOptional.get();
        }

        throw new Exception("Verification code not found");
    }

    @Override
    public VerificationCode getVerificationCodeByUser(Long id) {
        return verificationCodeRepository.findByUserId(id);
    }

    @Override
    public void deleteVerificationCodeById(VerificationCode verificationCode) {
        verificationCodeRepository.delete(verificationCode);
    }
}
