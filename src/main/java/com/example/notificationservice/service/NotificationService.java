package com.example.notificationservice.service;

import com.example.notificationservice.dto.CustomerNotificationPreferences;
import com.example.notificationservice.dto.LoanCreatedEventPayload;
import com.example.notificationservice.dto.LoanOverdueEventPayload;
import com.example.notificationservice.enums.NotificationType;
import com.example.notificationservice.helper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final CustomerPreferenceService customerPreferenceService;
    private final NotificationTemplateService notificationTemplateService;
    private final SmsService smsService;
    private final EmailService emailService;
    private final PushNotificationService pushNotificationService;

    public void sendLoanCreationNotification(LoanCreatedEventPayload event) {
        sendNotification(
                event.getCustomerId(),
                NotificationType.LOAN_CREATION,
                Map.of(
                        "loanId", event.getLoanId(),
                        "loanAmount", event.getAmount(),
                        "dueDate", event.getDueDate()
                )
        );
    }

    public void handleLoanOverdueNotification(LoanOverdueEventPayload event) {
        sendNotification(
                event.getCustomerId(),
                NotificationType.LOAN_OVERDUE,
                Map.of(
                        "loanId", event.getLoanId(),
                        "overdueAmount", event.getOverdueAmount(),
                        "dueDate", event.getDueDate()
                )
        );
    }

    private void sendNotification(Long customerId, NotificationType type, Map<String, Object> placeholders) {
        CustomerNotificationPreferences preferences = customerPreferenceService.getPreferences(customerId);
        String message = notificationTemplateService.generateMessage(type.getTemplateKey(), placeholders);

        if (preferences.isSmsEnabled()) {
            smsService.send(customerId, message);
        }
        if (preferences.isEmailEnabled()) {
            emailService.send(customerId, message);
        }
        if (preferences.isPushNotificationEnabled()) {
            pushNotificationService.send(customerId, message);
        }

        log.info("{} Notification sent for Customer {}: {}", type, customerId, message);
    }
}
