package com.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film{
	
	private int id;
	private int sessionQuantity;
	private ArrayList<Chapter> chapters;
	
	public Serie(String title, String genre, String creator, int duration, int sessionQuantity, ArrayList<Chapter> chapters) {
		super(title, genre, creator, duration);
		this.sessionQuantity = sessionQuantity; //Sobreescribir al método constructor de la clase Film
		this.chapters = chapters;
	}
	
	public int getId() {
		return id;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	public String toString() {
		return "\n :: SERIE ::" +
			    "\n Title: " + getTitle() +
			    "\n Genre: " + getGenre() +
			    "\n Year: " + getYear() +
			    "\n Creation: " + getCreator() +
			    "\n Duration:_" + getDuration();
	}
	
	//Nos da una lista de series
	public static ArrayList<Serie> makeSeriesList() {
		ArrayList<Serie> series = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			series.add(new Serie("Serie: " + i, "Genre: " + i, "Creator: " + i, 1200, 5, Chapter.makeChaptersList()));
		}
		return series;
	}
	
	
}






















