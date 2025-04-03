package com.movieapp.main.service;

import com.movieapp.main.entity.Movie;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    Movie addMovie(Movie movie);
    List<Movie> addMovies(List<Movie> movies);
    Movie getMovieById(Long id);
    List<Movie> getAllMovies(Pageable pageable);
    Movie updateMovie(Movie movie);
    String deleteMovieById(Long id);
    List<Movie> findByTitle(String title);
    List<Movie> findByReleaseYear(Integer year, Pageable pageable);
}