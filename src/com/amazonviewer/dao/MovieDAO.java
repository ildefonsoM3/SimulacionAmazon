package com.amazonviewer.dao;

import java.util.ArrayList;

import com.amazonviewer.model.Movie;

public interface MovieDAO {
	
	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	//Lista de películas que tú ya viste
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList();
		return movies;
	}
	
	//Que películas si están vistas y no están vistas
	private boolean getMovieViewed() {
		return false;
	}
	
}
