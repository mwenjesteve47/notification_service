package com.example.notificationservice.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PushNotificationService {
    private final RestTemplate restTemplate = new RestTemplate();

    public void send(Long customerId, String message) {
        log.info("Sending push notifications to customer " + customerId + " with message " + message);
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Notification for Customer " + customerId);
        payload.put("message", message);

        // Sending push notification to Gotify
//        String url = "http://localhost:8080/message?token=YOUR_GOTIFY_TOKEN";
//        restTemplate.postForEntity(url, payload, String.class);

        log.info("Push Notification Sent to Gotify!");
    }
}
