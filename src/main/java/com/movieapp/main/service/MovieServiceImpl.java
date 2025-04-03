package com.movieapp.main.service;

import com.movieapp.main.entity.Movie;
import com.movieapp.main.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> addMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> getAllMovies(Pageable pageable) {
        return movieRepository.findAll(pageable).getContent();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie existingMovie = getMovieById(movie.getId());
        if (existingMovie != null) {
            // Update all fields unconditionally since primitives can't be null
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setDirector(movie.getDirector());
            existingMovie.setGenre(movie.getGenre());
            existingMovie.setReleaseYear(movie.getReleaseYear());
            existingMovie.setImdbRating(movie.getImdbRating());
            return movieRepository.save(existingMovie);
        }
        return null;
    }

    @Override
    public String deleteMovieById(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return "Movie deleted with ID: " + id;
        }
        return "Movie not found with ID: " + id;
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> findByReleaseYear(Integer year, Pageable pageable) {
        return movieRepository.findTopByReleaseYear(year, pageable);
    }
}