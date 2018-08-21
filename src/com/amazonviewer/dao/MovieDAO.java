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
		try(Connection connection = connectToDB()) {
			//Prepara el objeto para que pueda ejecutar acciones en la base de datos
			Statement statement = connection.createStatement();
			String query = "INSERT INTO " + TVIEWED +  
					" ("+ TVIEWER_IDMATERIAL+", "+TVIEWER_IDELEMENT+", "+TVIEWER_IDUSER+")"
					+" VALUES("+ID_TMATERIAL [0]+", "+movie.getId()+", "+TUSER_IDUSUARIO+")";
			
			if (statement.executeUpdate(query) > 0) {
				System.out.println("Se insertó un registro");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return movie;
	}
	
	//Lista de películas que tú ya viste
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList();
		
		try (Connection connection = connectToDB()) {
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			//Disparador, ejecuta el query y trae los datos. Ayuda a poder iterar los datos
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE),
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR),
						Integer.valueOf(rs.getInt(TMOVIE_DURATION)), 
						Short.valueOf(rs.getShort(TMOVIE_YEAR)) );
				
				//Se agrega al ArrayList
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				
				movie.setViewed(getMovieViewed(
						preparedStatement, 
						connection, 
						Integer.valueOf(rs.getString(TMOVIE_ID))));
				
				movies.add(movie);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return movies;
	}
	
	//Que películas si están vistas y no están vistas
	private boolean getMovieViewed(PreparedStatement preparedStatement, 
			Connection connection, int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM " + TVIEWED +
				" WHERE " + TVIEWER_IDMATERIAL + "= ?" +
				" AND " + TVIEWER_IDELEMENT + " = ?" +
				" AND " + TVIEWER_IDUSER + " = ?";
		ResultSet rs = null;
		
		try {
			//Parámetros del query
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ID_TMATERIAL[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_IDUSUARIO);
			
			//Disparador, ejecuta el query y trae los datos. Ayuda a poder iterar los datos
			rs = preparedStatement.executeQuery();
			
			//Validación. Si hay un dato el valor que va a devolver será true
			viewed = rs.next();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return viewed;
	}
	
}



















