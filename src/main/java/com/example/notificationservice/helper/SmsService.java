package com.example.notificationservice.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsService {
    public void send(Long customerId, String message) {
        log.info(" Sending SMS to Customer {}: {}", customerId, message);
        // TODO: Integrate with SMS Provider (Twilio, Africa’s Talking, etc.)
    }
}
