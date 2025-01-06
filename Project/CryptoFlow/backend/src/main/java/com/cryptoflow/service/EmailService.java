package com.cryptoflow.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Slf4j
public class EmailService {

    private JavaMailSender mailSender;

    private Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    public void sendVerificationOtpMail(String email, String otp) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");

        String subject = "Verification OTP";
        String text = "Your verification code is " + otp + ".";

        try {
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text, true);
            mimeMessageHelper.setTo(email);

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());

            throw new MessagingException(e.getMessage());
        }
    }
}
