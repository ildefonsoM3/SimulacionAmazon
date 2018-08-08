package com.amazonviewer.model;

import java.util.ArrayList;

/**
 * Hereda de {@link Movie}
 * @see Film
 *
 */
public class Chapter extends Movie {
	
	private int id;
	private int sessionNumber;
	private Serie serie;
	
	public Chapter(String title, String genre, String creator, 
					int duration, short year, int sessionNumber, Serie serie) {
		super(title, genre, creator, duration, year);
		this.setSessionNumber (sessionNumber);
		this.setSerie(serie);
	}
	
	@Override
	public int getId() {
		return this.id; //Devuelve el id del hijo. "Polimorfismo"
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return  "\n :: SERIE ::" +
			    "\n Title: " + getSerie().getTitle() +
			    "\n :: CHAPTER ::" +
			    "\n Title: " + getTitle() +
			    "\n Year: " + getYear() +
			    "\n Creation: " + getCreator() +
			    "\n Duration: " + getDuration();
	}	
	
	public static ArrayList<Chapter> makeChaptersList(Serie serie) {
		ArrayList<Chapter> chapters = new ArrayList();
		
		for(int i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Cap�tulo " + i, "genero  " +i, "creador " +i, 45, (short)(2017+i), i, serie));
		}
		return chapters;
	}
	
	@Override
	//La serie se marcar� en visto cuando todos los cap�tulos se hayan visto
	public void view() {
		
		super.view();
		//Dame la serie que tienes y de la serie dame los cap�tulos que tienes
		ArrayList<Chapter> chapters = getSerie().getChapters();
		int chapterViewedCounter = 0;
		
		/*Si todos los cap�tulos vistos son del mismo tama�o  de cap�tulos de la serie entonces
		se marcar la serie en vista*/
		for (Chapter chapter: chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter++;
			}
		}
		
		if (chapterViewedCounter == chapters.size()) {
			getSerie().view();
		}
	}

}





















