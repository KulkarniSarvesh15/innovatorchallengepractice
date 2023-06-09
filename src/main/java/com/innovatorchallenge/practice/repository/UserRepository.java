package com.innovatorchallenge.practice.repository;

import com.innovatorchallenge.practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserName(Long username);
}
