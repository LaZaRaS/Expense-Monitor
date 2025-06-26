package service;

import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.stereotype.Service;
import repo.UserRepo;

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
}
