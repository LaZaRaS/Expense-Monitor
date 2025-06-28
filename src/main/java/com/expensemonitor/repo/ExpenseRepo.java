package com.expensemonitor.repo;

import com.expensemonitor.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    List<Expense> findByGroupName(String groupName);
    List<Expense> findByGroupId(Long groupId);
    List<Expense> findByPaidUserId(Long paidUserId);
}
