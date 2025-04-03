package com.movieapp.main.repository;

import com.movieapp.main.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable; // Add this import

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Optimized query for searching by title (uses idx_movie_title index)
    @Query("SELECT m FROM Movie m WHERE m.title = :title")
    List<Movie> findByTitle(@Param("title") String title);

    // Optimized query for filtering by release year with pagination (uses idx_movie_release_year index)
    @Query("SELECT m FROM Movie m WHERE m.releaseYear = :year")
    List<Movie> findTopByReleaseYear(@Param("year") int year, Pageable pageable);

    // Optional: Query for genre search (uses idx_movie_genre index)
    @Query("SELECT m FROM Movie m WHERE m.genre LIKE %:genre%")
    List<Movie> findByGenre(@Param("genre") String genre);

    // Optional: Query for top-rated movies (uses idx_movie_imdb_rating index)
    @Query("SELECT m FROM Movie m ORDER BY m.imdbRating DESC")
    List<Movie> findAllOrderByImdbRatingDesc(Pageable pageable);
}