package com.example.notificationservice.listener;

import com.example.notificationservice.dto.LoanCreatedEventPayload;
import com.example.notificationservice.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanCreationNotificationConsumer {
    private final NotificationService notificationService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "loan.notification.queue")
    public void handleLoanCreationEvent(String message) {
        try {
            LoanCreatedEventPayload event = objectMapper.readValue(message, LoanCreatedEventPayload.class);
            log.info("Received Loan Creation Event payload: {}", event);

            // Send notification
            notificationService.sendLoanCreationNotification(event);

        } catch (Exception e) {
            log.error("Error processing Loan Creation Event payload: {}", e.getMessage(), e);
        }
    }
}
