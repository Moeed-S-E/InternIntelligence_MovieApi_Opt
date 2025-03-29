package com.movieapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieapp.main.entity.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {
}
