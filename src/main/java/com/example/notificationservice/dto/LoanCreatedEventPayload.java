package com.example.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanCreatedEventPayload {
    private Long customerId;
    private Long loanId;
    private BigDecimal amount;
    private LocalDate dueDate;
    private String loanState;
}
