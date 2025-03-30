package com.example.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerNotificationPreferences {
    private boolean smsEnabled;
    private boolean emailEnabled;
    private boolean pushNotificationEnabled;
}
