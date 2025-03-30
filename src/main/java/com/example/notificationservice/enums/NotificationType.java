package com.example.notificationservice.enums;

import lombok.Getter;

@Getter
public enum NotificationType {
    LOAN_CREATION("LOAN_CREATION"),
    LOAN_OVERDUE("LOAN_OVERDUE");

    private final String templateKey;

    NotificationType(String templateKey) {
        this.templateKey = templateKey;
    }
}
