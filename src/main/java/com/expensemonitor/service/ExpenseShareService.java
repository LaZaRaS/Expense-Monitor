package com.expensemonitor.service;

import lombok.RequiredArgsConstructor;
import com.expensemonitor.model.Expense;
import com.expensemonitor.model.ExpenseShare;
import com.expensemonitor.model.User;
import org.springframework.stereotype.Service;
import com.expensemonitor.repo.ExpenseRepo;
import com.expensemonitor.repo.ExpenseShareRepo;
import com.expensemonitor.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseShareService {
    public final ExpenseShareRepo expenseShareRepo;
    public final UserRepo userRepo;
    public final ExpenseRepo expenseRepo;

    public void createShares(Long expenseId, List<Long> userIds) {
        Expense expense = expenseRepo.findById(expenseId).orElseThrow();
        double shareAmount = expense.getAmount()/userIds.size();
        List<ExpenseShare> expenseShares = new ArrayList<>();

        for (Long userId : userIds) {
            User user = userRepo.findById(userId).orElseThrow();

            ExpenseShare expenseShare = new ExpenseShare();
            expenseShare.setExpense(expense);
            expenseShare.setUser(user);
            expenseShare.setShareAmount(shareAmount);
            expenseShares.add(expenseShare);
        }
        expenseShareRepo.saveAll(expenseShares);
    }

    public List<ExpenseShare> getExpenseShares(Long expenseId) {
        return expenseShareRepo.findByExpenseId(expenseId);
    }

    public List<ExpenseShare> getUserShares(Long userId) {
        return expenseShareRepo.findByUserId(userId);
    }

    //Open an API endpoint later
    public void deleteShare(Long expenseId) {
        expenseShareRepo.deleteByExpenseId(expenseId);
    }
}
