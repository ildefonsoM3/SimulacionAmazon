package com.amazonviewer.model;

import java.util.*;

public class Book extends Publication implements IVisualizable {

	private int id;
	private String isbn;
	private boolean read;
	private int timeRead;
	private String[] authors;
	
	
	public Book(String title, Date editorialDate, String editorial, String[] authors) {
		super(title, editorialDate, editorial);
		this.isbn = isbn;
	}
	
	public int getId(int id) {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public int getTimeRead() {
		return timeRead;
	}

	public void setTimeRead(int timeRead) {
		this.timeRead = timeRead;
	}

	@Override
	public String toString() {
		String detailBook = "\n :: BOOK ::" +
						    "\n Title: " + getTitle() +
						    "\n Editorial: " + getEditorial() +
						    "\n Edition Date: " + getEditorialDate() +
						    "\n Authors: ";
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t" + getAuthors()[i];
		}
		return detailBook;
		
	}

	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if (dateF.getTime() > dateI.getTime()) {
			setTimeRead((int)(dateF.getTime() - dateI.getTime()));
			
		} else {
			setTimeRead(0);
		}
		
	}
	
	//Genera una lista de películas 
	public static ArrayList<Book> makeBooksList() {
		ArrayList<Book> books = new  ArrayList();
		
		/*for(int i = 0; i < 4; i++) {
			books.add(new Book("Book: " + i+1, "Date: "+ Date + "Editorial: " + i+1, "Authors: " + i+1));
		}*/
		return books;
		
	}
	
	
}



















