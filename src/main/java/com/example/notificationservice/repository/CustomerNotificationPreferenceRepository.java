package com.example.notificationservice.repository;

import com.example.notificationservice.model.CustomerNotificationPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerNotificationPreferenceRepository extends JpaRepository<CustomerNotificationPreferences,Long> {
    Optional<CustomerNotificationPreferences> findByCustomerId(Long customerId);
}
