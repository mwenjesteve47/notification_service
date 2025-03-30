package com.example.notificationservice.helper;

import com.example.notificationservice.dto.CustomerNotificationPreferences;
import com.example.notificationservice.repository.CustomerNotificationPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerPreferenceService {

    private final CustomerNotificationPreferenceRepository customerNotificationPreferenceRepository;

    public CustomerNotificationPreferences getPreferences(Long customerId) {
            return customerNotificationPreferenceRepository.findByCustomerId(customerId)
                    .map(customerPreference -> new CustomerNotificationPreferences(
                            customerPreference.isSmsEnabled(),
                            customerPreference.isEmailEnabled(),
                            customerPreference.isPushNotificationEnabled()
                    ))
                    .orElseGet(() -> new CustomerNotificationPreferences(true, true, false)); // Default settings
    }

}
