package com.company.esports.module2user.services;

import com.company.esports.module2user.dto.UserDto;
import com.company.esports.module2user.entities.User;
import com.company.esports.module2user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User createUser(UserDto userDto){
        User user = new User();
        user.setUser_id(UUID.randomUUID().toString());
        user.setUsertag(userDto.getUsertag());
        user.setEmail(userDto.getUsername());
        user.setPassword_hash(passwordEncoder.encode(userDto.getPassword_hash()));
        user.setStatus("ACTIVE");
        if(userDto.getRole().equals("ADMIN")) {
            user.setRole("ADMIN");
        }else{
            user.setRole("PLAYER");
        }
        return userRepository.save(user);
    }
}