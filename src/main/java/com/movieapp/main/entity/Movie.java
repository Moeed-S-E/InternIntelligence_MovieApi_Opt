package com.movieapp.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
=======
import lombok.AllArgsConstructor;
>>>>>>> 5d8d9cd (Polish Swagger)
import lombok.Data;
import lombok.NoArgsConstructor;


<<<<<<< HEAD
=======
@AllArgsConstructor
>>>>>>> 5d8d9cd (Polish Swagger)
@NoArgsConstructor
@Data
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String director;
    private int releaseYear;
    private String genre;
    private double imdbRating;
	
<<<<<<< HEAD
    public Movie(Long id, String title, String director, int releaseYear, String genre, double imdbRating) {
    	this.id = id;
		this.title = title;
		this.director = director;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.imdbRating = imdbRating;
	}
	public Long getId() {
=======
    public Long getId() {
>>>>>>> 5d8d9cd (Polish Swagger)
		return id;
	}
    public String getTitle() {
		return title;
	}
    public String getDirector() {
		return director;
	}
    public int getReleaseYear() {
		return releaseYear;
	}
    public String getGenre() {
		return genre;
	}
    public double getImdbRating() {
		return imdbRating;
	}
    public void setId(Long id) {
		this.id = id;
	}
    public void setTitle(String title) {
		this.title = title;
	}
    public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
    public void setDirector(String director) {
		this.director = director;
	}
    public void setGenre(String genre) {
		this.genre = genre;
	}
    public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
    
    
}
