package com.expensemonitor.service;

import lombok.RequiredArgsConstructor;
import com.expensemonitor.model.User;
import org.springframework.stereotype.Service;
import com.expensemonitor.repo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
    return userRepo.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
