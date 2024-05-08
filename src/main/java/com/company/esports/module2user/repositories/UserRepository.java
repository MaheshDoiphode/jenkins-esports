package com.company.esports.module2user.repositories;

import com.company.esports.module2user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findByEmail(String email);
}