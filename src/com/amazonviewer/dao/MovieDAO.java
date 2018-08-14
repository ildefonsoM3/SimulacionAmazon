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
	
	//Lista de pel�culas que t� ya viste
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList();
		try (Connection connection = connectToDB()) {
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return movies;
	}
	
	//Que pel�culas si est�n vistas y no est�n vistas
	private boolean getMovieViewed() {
		return false;
	}
	
}
