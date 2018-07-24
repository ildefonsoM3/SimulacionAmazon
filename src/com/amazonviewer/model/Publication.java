package com.amazonviewer.model;

import java.util.Date;

public class Publication {
	
	private String title;
	private String editorial;
	private String[] authors;
		
	public Publication(String title, String editorial) {
		super();
		this.title = title;
		this.editorial = editorial;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

}
