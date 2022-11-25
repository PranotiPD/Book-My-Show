package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShowRepository extends JpaRepository<Show, Integer> {
}
