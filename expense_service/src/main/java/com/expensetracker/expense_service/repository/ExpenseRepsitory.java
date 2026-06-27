package com.expensetracker.expense_service.repository;

import com.expensetracker.expense_service.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepsitory extends JpaRepository<Expense,Long> {

    List<Expense> findByUserId(Long userId);
}
