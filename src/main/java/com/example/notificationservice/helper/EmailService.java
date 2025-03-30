package com.example.notificationservice.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(Long customerId, String message) {
        log.info("Sending email to customer {} with message {}", customerId, message);
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("mwenjestevie47@gmail.com");
        email.setSubject("Hello Customer " + customerId);
        email.setText(message);

        mailSender.send(email);
        log.info("Email sent!");
    }
}
