package com.movieapp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.main.entity.Movie;
import com.movieapp.main.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public List<Movie> addMovies(List<Movie> movies) {
		return movieRepository.saveAll(movies);
	}
	
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).orElse(null);
	}
	
	public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
	
	public Movie updateMovie(Movie movie) {
		Movie existingMovie = getMovieById(movie.getId());
		if (existingMovie != null) {
			existingMovie.setTitle(movie.getTitle());
			existingMovie.setDirector(movie.getDirector());
			existingMovie.setGenre(movie.getGenre());
			existingMovie.setReleaseYear(movie.getReleaseYear());
			existingMovie.setImdbRating(movie.getImdbRating());
			return movieRepository.save(existingMovie);
		}
		else {
			return null;
		}
		
	}
	public String deleteMovieById(Long id) {
        movieRepository.deleteById(id);
        return "Movie deleted with ID: " + id;
    }
	
}
