package com.movieapp.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
    name = "movies",
    indexes = {
        @Index(name = "idx_movie_title", columnList = "title"),
        @Index(name = "idx_movie_release_year", columnList = "releaseYear"),
        @Index(name = "idx_movie_genre", columnList = "genre"),
        @Index(name = "idx_movie_imdb_rating", columnList = "imdbRating")
    }
)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Title is mandatory
    private String title;

    @Column // Director can be null
    private String director;

    @Column
    private int releaseYear;

    @Column
    private String genre;

    @Column
    private double imdbRating;
}