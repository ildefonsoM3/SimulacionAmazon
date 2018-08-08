package com.amazonviewer.model;

import java.util.*;

import com.amazonviewer.util.AmazonUtil;

public class Book extends Publication implements IVisualizable {

	private int id;
	private String isbn;
	private boolean read;
	private int timeRead;
	private ArrayList<Page> pages;
	
	
	public Book(String title, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, editorial);
		setAuthors(authors);
		this.pages = pages;
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

	public String isRead() {
		String leido = "";
		if (read == true) {
			leido = "Sí";
		}else {
			leido = "No";
		}
		return leido;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
	
	public boolean getIsRead() {
		return read;
	}

	public int getTimeRead() {
		return timeRead;
	}

	public void setTimeRead(int timeRead) {
		this.timeRead = timeRead;
	}
	
	public ArrayList<Page> getPages() {
		return pages;
	}

	
	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		String detailBook = "\n :: BOOK ::" +
						    "\n Title: " + getTitle() +
						    "\n Editorial: " + getEditorial() +
						    "\n Authors: ";
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t" + getAuthors()[i] + " ";
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
	
	////////////////////////////////////////////////////
	public void view() {
		setRead(true);
		Date dateI = startToSee(new Date());
		
		int numberPagesRead = 0;
		
		do {
			System.out.println("....................");
			System.out.println("Page " + getPages().get(numberPagesRead).getNumber());
			System.out.println(getPages().get(numberPagesRead).getContent());
			System.out.println("....................");
			
			if (numberPagesRead != 0) {
				System.out.println("1. Regresar página");
			}
			
			System.out.println("2. Siguiente página");
			System.out.println("0. Cerrar libro");
			System.out.println();
			//No se puede ingresar otra opción que no sea 0 - 2
			int response = AmazonUtil.validateUserResponseMenu(0, 2);
			
			if (response == 2) 
				numberPagesRead++;
			else if (response == 1) 
				numberPagesRead--;
			 else if (response == 0)
				break;
			
		} while (numberPagesRead < getPages().size());
		
		////////LLLLLLLLLLLLLLLLLLLLLLLLLL////////
		int pagesReadBook = 0;
		  for (Page p : pages) {
		   /* if (p.isRead()) {
		      pagesReadBook++;
		    }*/
		  }
		/////////LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL/////////
		//Termine de leerlo
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Leíste: " + toString());
		System.out.println("Por: " + getTimeRead() + " milisegundos");
	}
	////////////////////////////////////////////////////
	
	//Genera una lista de películas 
	public static ArrayList<Book> makeBooksList() {
		ArrayList<Book> books = new  ArrayList();
		String[] authors = new String[3];
		//Se crea lista de autores
		for (int i = 0; i < 3; i++) {
			authors[i] = "author " + i;
		}
		
		ArrayList<Page> pages = new ArrayList();
		int numeroPagina = 0;
		//Se crean 3 páginas por libro
		for (int i = 0; i < 3; i++) {
			numeroPagina = i+1;
			pages.add(new Book.Page(numeroPagina, " El contenidos de la página " + numeroPagina));
		}
		
		//Lista de libros se agrega la lista de autores
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, "editorial " + i, authors, pages));
		}
		
		return books;
		
	}
	
	
	public static class Page {
		private int id;
		private int number;
		private String content;
		
		public Page(int number, String content){
			super();
			this.number = number;
			this.content = content;
		}

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public int getNumber() {
			return number;
		}
		
		public void setNumber(int number) {
			this.number = number;
		}
		
		public String getContent() {
			return content;
		}
		
		public void setContent(String content) {
			this.content = content;
		}
		
		
	}
	
	
}



















