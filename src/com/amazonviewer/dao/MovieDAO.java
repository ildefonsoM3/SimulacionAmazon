package com.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static com.amazonviewer.db.DataBase.*;

import com.amazonviewer.db.IDBConnection;
import com.amazonviewer.model.Movie;

public interface MovieDAO extends IDBConnection {
	
	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	//Lista de películas que tú ya viste
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList();
		try (Connection connection = connectToDB()) {
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return movies;
	}
	
	//Que películas si están vistas y no están vistas
	private boolean getMovieViewed() {
		return false;
	}
	
}
