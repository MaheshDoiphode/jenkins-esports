package com.company.esports.module2user.services;

import com.company.esports.module2user.dto.UserDto;
import com.company.esports.module2user.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public User createUser(UserDto userDto);
    public List<User> getUsers();
}
