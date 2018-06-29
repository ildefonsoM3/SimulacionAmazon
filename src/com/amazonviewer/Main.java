package com.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.*;

import com.amazonviewer.model.Book;
import com.amazonviewer.model.Chapter;
import com.amazonviewer.model.Movie;
import com.amazonviewer.model.Serie;
import com.pm3.makereport.Report;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Movie movie = new Movie("Coco", "Animation", null, (short) 2017, 0);
		// movie.showData();
		showMenu();
	}
	
	public static void showMenu() {
		int exit = 0;
		do {
			System.out.println("YOU'RE WELCOME TO AMAZON VIEWER");
			System.out.println("");
			System.out.println("Select your option");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			
			// Respuesta del usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			switch (response) {
				case 0:
					// Salir
					exit = 0;
					break;
				case 1:
					showMovies();
					break;
				case 2:
					showSeries();
					break;
				case 3:
					showBooks();
					break;
				case 4:
					showMagazines();
					break;
				case 5:
					makeReport();
					break;
				case 6:
					makeReport(new Date());
					break;
				default:
					System.out.println("");
					System.out.println("....¡¡Seleciona una opción!!....");
					System.out.println("");
					break;
			}
			
		} while (exit != 0);
	}
	
	
	static ArrayList<Movie> movies;
	public static void showMovies() {
		int exit = 1;
		// Se manda a llamar al método estático
		movies = Movie.makesMoviesList();
		
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			
			// Se usa size() porque se esta usando una colección
			for (int i = 0; i < movies.size(); i++) { // 1. Movie 1
				System.out.println(
						(i + 1) + ". " + movies.get(i).getTitle() + 
						" Viewed: " + movies.get(i).isViewed());
			}
			
			System.out.println();
			System.out.println("0. Return to Menu");
			System.out.println();
			
			//Leer respuesta del usuario
			Scanner sc2 = new Scanner(System.in);
			int response2 = Integer.valueOf(sc2.nextLine());
			System.out.println();
			
			if(response2 == 0) {
				
				showMenu();
				
			} else if (response2 > 0) {
				
				Movie movieSelected = movies.get(response2-1);
				//Se marca la película como vista
				movieSelected.setViewed(true);
				//Se da la hora en la que se empezó a ver
				Date dateI = movieSelected.startToSee(new Date());
				
				//Simulación de que se esta viendo el capítulo
				for (int i = 0; i < 100000; i++) 
					System.out.println("..........");
				
				//Termina de ver la película
				movieSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Viste: " + movieSelected.getTimeViewed() + " milisegundos");
				
				System.out.println();
				System.out.println("0. Return to menu");
				System.out.println();
				
			}
			
			
		} while (exit != 0);
		
	}
	
	public static void showSeries() {
		int exit = 1;
		ArrayList<Serie> series = Serie.makeSeriesList();
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
			
			//size() es para recorrer una colección
			for (int i = 0; i < series.size(); i++) {//1. Serie 1
				System.out.println(i+1 + ". " + series.get(i).getTitle() + " Viewed: " + series.get(i).isViewed());
			}
			
			System.out.println();
			System.out.println("0. Return to Menu");
			System.out.println();
			
			Scanner sc2 = new Scanner(System.in);
			int response2 = Integer.valueOf(sc2.nextLine());
			System.out.println();
			
			if(response2 == 0) {
				showMenu();
			} else if(response2 > 0) {
				showChapters(series.get(response2-1).getChapters());
			}
						
			
		} while (exit != 0);
		
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 0;
		
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
				System.out.println(i+1 + " ." + chaptersOfSerieSelected.get(i).getTitle() + 
						" Viewed: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println();
			System.out.println("0. Return to Menu");
			System.out.println();
			
			Scanner sc2 = new Scanner(System.in);
			int response2 = Integer.valueOf(sc2.nextLine());
			
			if(response2 == 0)
				showSeries();
			
			Chapter chapterSelected = chaptersOfSerieSelected.get(response2-1);
			chapterSelected.setViewed(true);
			Date dateI = chapterSelected.startToSee(new Date());
			
			//Simulación
			for (int i = 0; i < 100000; i++) 
				System.out.println("..........");
			
			//Termin a de ver la serie
			chapterSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("You viewed: " + chapterSelected);
			System.out.println("by " + chapterSelected.getTimeViewed() + " miliseconds");			
			
		} while (exit != 0);
		
	}
	
	public static void showBooks() {
		int exit = 0;
		ArrayList<Book> books = Book.makeBooksList();
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			
			for (int i = 0; i < books.size(); i++) {
				System.out.println(
						(i+1) + ". " + "Book: " + books.get(i).getTitle()
						+ "Editorial: " + books.get(i).getEditorial() 
						+ "Book read: " + books.get(i).isRead());				
			}
			
		} while (exit != 0);
		
	}
	
	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
		} while (exit != 0);
		
	}
	
	public static void makeReport() {
		
		Report report = new Report(); 
		report.setNameFile("REPORTE");
		report.setExtension("txt");
		report.setTitle("::VISTO::");
		
		String contentReport = "";
		
		for (Movie movie: movies) {
			if (movie.getIsViewed()) 
				contentReport += movie.toString() + "\n";
		}
		
		report.setContent(contentReport);
		report.makeReport();
		
	}
	
	public static void makeReport(Date date) {
		//Patron para la fecha
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		//Paso el formato "date" al formato solicitado
		String dateString = df.format(date);
		Report report = new Report();
		
		report.setNameFile("REPORTE " + dateString);
		report.setExtension("txt");
		report.setTitle("::VISTO::");
		
		String contentReport = "";
		
		for (Movie movie: movies) {
			if (movie.getIsViewed()) 
				contentReport += movie.toString() + "\n";
		}
		
		report.setContent(contentReport);
		report.makeReport();
				
	}
}











