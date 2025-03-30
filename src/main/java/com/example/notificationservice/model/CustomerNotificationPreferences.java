package com.example.notificationservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer_notification_preferences")
public class CustomerNotificationPreferences {
    @Id
    private Long customerPreferenceId;
    private Long customerId;
    private boolean smsEnabled;
    private boolean emailEnabled;
    private boolean pushNotificationEnabled;
}
