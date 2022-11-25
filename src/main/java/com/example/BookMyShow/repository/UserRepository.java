package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
