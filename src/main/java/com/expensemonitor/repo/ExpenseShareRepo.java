package com.expensemonitor.repo;

import com.expensemonitor.model.ExpenseShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseShareRepo extends JpaRepository<ExpenseShare, Long> {
    List<ExpenseShare> findByExpenseId(Long expenseId);

    List<ExpenseShare> findByUserId(Long userId);

    void deleteByExpenseId(Long expenseId);
}
