package com.amazonviewer.model;

import java.util.*;

public class Movie extends Film implements IVisualizable{
	
	private int id;
	private int timeViewed;	

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year); //Sobreescribir al método constructor de la clase Film
	}
	
	public void showData() {
		//System.out.println("Title:: " + title);
		//System.out.println("Genre:: " + genre);
		//System.out.println("Year:: " + year);
	}

	public int getId() {
		return id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	public String toString() {
		return 	    "\n :: MOVIE ::" +
				    "\n Title: " + getTitle() +
				    "\n Genre: " + getGenre() +
				    "\n Year: " + getYear() +
				    "\n Creator: " + getCreator() +
				    "\n Duration: " + getDuration() ;
	}

	@Override
	//Solo es un check-in del tiempo inicial visto
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	//Se toma la hora final y se resta la hora inicial
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
		if (dateF.getTime() > dateI.getTime()) {
			//Se castea el resultado de long a int
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
			
		} else {
			setTimeViewed(0);
		}
		
	}
	
	//Genera una lista de películas 
	public static ArrayList<Movie> makesMoviesList() {
		ArrayList<Movie> movies = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			movies.add(new Movie("Movie " + i, "Genero " + i, "Creador " + i, 120+i, (short)(2017+i)));
		}
		
		return movies;
				
	}
	
	@Override
	public void view() {
		
		setViewed(true);
		//Se da la hora en la que se empezó a ver
		Date dateI = startToSee(new Date());
		
		//Simulación de que se esta viendo el capítulo
		for (int i = 0; i < 100000; i++) 
			System.out.println("..........");
		
		//Termina de ver la película
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + " milisegundos");
	}
	
}



























