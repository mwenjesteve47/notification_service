package com.example.notificationservice.listener;

import com.example.notificationservice.dto.LoanOverdueEventPayload;
import com.example.notificationservice.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanOverdueNotificationConsumer {
    private final NotificationService notificationService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "loan.loanOverdueNotification.queue")
    public void handleLoanOverdueEvent(String message) {
        try {
            LoanOverdueEventPayload event = objectMapper.readValue(message, LoanOverdueEventPayload.class);
            log.info("Received Loan Overdue Event: {}", event);

            // Send notification
            notificationService.handleLoanOverdueNotification(event);

        } catch (Exception e) {
            log.error("Error processing Loan Overdue Event: {}", e.getMessage(), e);
        }
    }
}
