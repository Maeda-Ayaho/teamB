package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT a FROM User a WHERE a.username = :username AND a.password = :password")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User findByUsername(String username);
}


