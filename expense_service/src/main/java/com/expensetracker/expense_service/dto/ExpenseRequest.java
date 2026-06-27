package com.expensetracker.expense_service.dto;

import lombok.Data;

@Data
public class ExpenseRequest {

    private Long userId;

    private Double amount;

    private String category;

    private String description;
}
