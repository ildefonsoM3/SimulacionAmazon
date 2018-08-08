package com.amazonviewer.dao;

import java.util.ArrayList;

import com.amazonviewer.model.Movie;

public interface MovieDAO {
	
	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	//Lista de pel�culas que t� ya viste
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList();
		return movies;
	}
	
	//Que pel�culas si est�n vistas y no est�n vistas
	private boolean getMovieViewed() {
		return false;
	}
	
}
