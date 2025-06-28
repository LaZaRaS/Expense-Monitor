package com.expensemonitor.controller;

import com.expensemonitor.model.ExpenseShare;
import com.expensemonitor.service.ExpenseShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenseshares")
@RequiredArgsConstructor
public class ExpenseShareController {
    private final ExpenseShareService expenseShareService;

    @PostMapping("/{expenseId}")
    public void expenseShare(@PathVariable Long expenseId, @RequestBody List<Long> userIds) {
        expenseShareService.createShares(expenseId, userIds);
    }

    @GetMapping("/expense/{expenseId}")
    public List<ExpenseShare> getExpenseShares(@PathVariable Long expenseId) {
        return expenseShareService.getExpenseShares(expenseId);
    }

    @GetMapping("/user/{userId}")
    public List<ExpenseShare> getUserShares(@PathVariable Long userId) {
        return expenseShareService.getUserShares(userId);
    }
}
