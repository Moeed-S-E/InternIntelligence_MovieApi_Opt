package com.movieapp.main.dto;

public class MovieDTO {
    private Long id;
    private String title;
    private String director;
    private int releaseYear;
    private String genre;
    private double imdbRating;

    public MovieDTO() {}
    public MovieDTO(Long id, String title, String director, int releaseYear, String genre, double imdbRating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.imdbRating = imdbRating;
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public int getReleaseYear() { return releaseYear; }
    public String getGenre() { return genre; }
    public double getImdbRating() { return imdbRating; }
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setImdbRating(double imdbRating) { this.imdbRating = imdbRating; }
}