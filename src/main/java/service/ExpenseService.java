package service;

import lombok.RequiredArgsConstructor;
import model.Expense;
import model.Group;
import model.User;
import org.springframework.stereotype.Service;
import repo.ExpenseRepo;
import repo.GroupRepo;
import repo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    public final ExpenseRepo expenseRepo;
    public final UserRepo userRepo;
    public final GroupRepo groupRepo;

    public Expense createExpense(Expense expense, Long userId, Long groupId) {
        User paidUser = userRepo.findById(userId).orElseThrow();
        Group group = groupRepo.findById(groupId).orElseThrow();

        expense.setPaidBy(paidUser);
        expense.setGroup(group);
        return expenseRepo.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    public Expense getExpenseById(Long expenseId) {
        return expenseRepo.findById(expenseId).orElseThrow();
    }

    public Expense updateExpense(Long id, Expense expense) {
        Expense expenseToUpdate = expenseRepo.findById(id).orElseThrow();
        expenseToUpdate.setAmount(expense.getAmount());
        expenseToUpdate.setDescription(expense.getDescription());
        expenseToUpdate.setExpenseDate(expense.getExpenseDate());

        return expenseRepo.save(expenseToUpdate);
    }

    public void deleteExpense(Long id) {
        Expense expenseToDelete = expenseRepo.findById(id).orElseThrow();
        expenseRepo.delete(expenseToDelete);
    }
}
