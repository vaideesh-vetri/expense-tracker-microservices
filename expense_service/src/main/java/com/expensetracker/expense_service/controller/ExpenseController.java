package com.expensetracker.expense_service.controller;

import com.expensetracker.expense_service.dto.ExpenseRequest;
import com.expensetracker.expense_service.entity.Expense;
import com.expensetracker.expense_service.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public String addExpense(@RequestBody ExpenseRequest request){
        return service.addExpense(request);
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getExpenses(@PathVariable Long userId){
        return service.getExpenses(userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteExpense(@PathVariable Long userId){
        return service.deleteExpense(userId);
    }
}
