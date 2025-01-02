package com.cryptoflow.entity;

import com.cryptoflow.domain.VerificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwoFactorAuth {

    private boolean isEnabled = false;
    private VerificationType sendTo;
}
