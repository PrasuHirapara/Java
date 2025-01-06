package com.cryptoflow.entity;

import com.cryptoflow.domain.VerificationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwoFactorAuth {

    private boolean isEnabled = false;
    private VerificationType sendTo;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public VerificationType getSendTo() {
        return sendTo;
    }

    public void setSendTo(VerificationType sendTo) {
        this.sendTo = sendTo;
    }
}
