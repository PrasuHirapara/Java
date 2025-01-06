package com.cryptoflow.repository;

import com.cryptoflow.entity.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {

    VerificationCode findByUserId(Long userId);
}
