package com.amazonviewer.model;

/**
 * <h1>Film</h1>
 * Film es una clase padre abstracta.
 * <p>
 * Es la clase base de la familia Films, como es abstracta no se puede instancias y por
 ende contiene el m�todo abstracto
 * {@code view()} que es obligatorio implementar para todo aquel que pertenezca a la 
 familia.
 *
 *@author ponchom3
 * @version 1.1
 *@since 2018
 */
public abstract class Film {
	
	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean viewed;
	
	public Film() {}
	
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String isViewed() {
		String visto = null;
		/*
		if(viewed)
			visto = "Yes";
		else
			visto = "No";
		*/
		
		visto = viewed ? "Yes" : "No";
		
		return visto;
	}
	
	public boolean getIsViewed() {
		return viewed;
	}
	
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	/**
	 * {@code view()} es un m�todo abstracto obligatorio de implementar.
	 */
	public abstract void view();

}














