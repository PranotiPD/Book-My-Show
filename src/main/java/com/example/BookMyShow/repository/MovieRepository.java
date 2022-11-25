package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    boolean existsByName(String name);
}
