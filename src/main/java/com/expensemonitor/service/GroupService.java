package com.expensemonitor.service;

import lombok.RequiredArgsConstructor;
import com.expensemonitor.model.Group;
import com.expensemonitor.model.User;
import org.springframework.stereotype.Service;
import com.expensemonitor.repo.GroupRepo;
import com.expensemonitor.repo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepo groupRepo;
    private final UserRepo userRepo;

    public Group createGroup(Group group, Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        group.setCreator(user);
        return groupRepo.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepo.findAll();
    }

    public Group getGroupById(Long groupId) {
        return groupRepo.findById(groupId).orElseThrow();
    }

    //Open an API endpoint later
    public Group updateGroup(Long groupId, Group groupEdit) {
        Group groupToChange = groupRepo.findById(groupId).orElseThrow();
        groupToChange.setName(groupEdit.getName());
        return groupRepo.save(groupToChange);
    }

    public void deleteGroup(Long groupId) {
            groupRepo.deleteById(groupId);
    }
}
