package com.example.notificationservice.helper;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationTemplateService {
    private static final Map<String, String> TEMPLATES = Map.of(
            "LOAN_CREATION", "Dear Customer, your loan (ID: {loanId}) of {loanAmount} has been approved. Due Date: {dueDate}.",
            "LOAN_OVERDUE", "Dear Customer, your loan (ID: {loanId}) is overdue. Amount Due: {overdueAmount}, Due Date: {dueDate}. Please make payment to avoid penalties."
    );

    public String generateMessage(String templateKey, Map<String, Object> placeholders) {
        String template = TEMPLATES.getOrDefault(templateKey, "Notification: {message}");
        for (Map.Entry<String, Object> entry : placeholders.entrySet()) {
            template = template.replace("{" + entry.getKey() + "}", entry.getValue().toString());
        }
        return template;
    }
}
