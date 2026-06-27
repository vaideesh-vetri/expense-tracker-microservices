package com.expensetracker.expense_service.service;

import com.expensetracker.expense_service.dto.ExpenseRequest;
import com.expensetracker.expense_service.entity.Expense;
import com.expensetracker.expense_service.repository.ExpenseRepsitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepsitory repository;

    public ExpenseService(ExpenseRepsitory repsitory) {
        this.repository = repsitory;
    }

    public String addExpense(ExpenseRequest request){

        Expense expense = new Expense();
        expense.setUserId(request.getUserId());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());

        repository.save(expense);

        return "Expense Added";
    }

    public List<Expense> getExpenses(Long userId){
        return repository.findByUserId(userId);
    }

    public String deleteExpense(Long userId){

        repository.deleteById(userId);

        return "Expense Deleted";
    }


}
