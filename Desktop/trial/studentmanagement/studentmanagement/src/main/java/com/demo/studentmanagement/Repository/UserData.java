package com.demo.studentmanagement.Repository;

import com.demo.studentmanagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserData extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
}