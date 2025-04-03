package com.movieapp.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movieapp.main.dto.MovieDTO;
import com.movieapp.main.entity.Movie;
import com.movieapp.main.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    @Operation(summary = "Create a new movie", description = "Adds a single movie")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Movie created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid movie data provided"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = new Movie(null, movieDTO.getTitle(), movieDTO.getDirector(), 
            movieDTO.getReleaseYear(), movieDTO.getGenre(), movieDTO.getImdbRating());
        Movie saved = movieService.addMovie(movie);
        return ResponseEntity.status(201).body(new MovieDTO(saved.getId(), saved.getTitle(), 
            saved.getDirector(), saved.getReleaseYear(), saved.getGenre(), saved.getImdbRating()));
    }

    @PostMapping("/bulk")
    @Operation(summary = "Add multiple movies", description = "Creates multiple movie records")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Movies created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid movie data provided"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Movie>> addMovies(@RequestBody List<Movie> movies) {
        return ResponseEntity.status(201).body(movieService.addMovies(movies));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a movie by ID", description = "Fetches a movie using its unique ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Movie found"),
        @ApiResponse(responseCode = "404", description = "Movie not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        return movie != null ? ResponseEntity.ok(movie) : ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Get all movies", description = "Retrieves all movies with optional pagination")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Movies retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Movie>> getAllMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(movieService.getAllMovies(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a movie", description = "Updates an existing movie by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Movie updated successfully"),
        @ApiResponse(responseCode = "404", description = "Movie not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        Movie updated = movieService.updateMovie(movie);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a movie", description = "Deletes a movie by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Movie deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Movie not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.deleteMovieById(id));
    }
}