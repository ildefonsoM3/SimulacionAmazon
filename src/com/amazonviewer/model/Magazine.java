package com.amazonviewer.model;

import java.util.*;

//Solo puede entrar a ver el cat�logo y no se pueden leer
public class Magazine extends Publication {
	
	private int id;
	
	public Magazine(String title, Date editorialDate, String editorial) {
		super(title, editorial);
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String detailMagazine = "\n :: MAGAZINE ::" + 
								"\n Title: " + getTitle() +
								"\n Editorial: " + getEditorial() + 
								"\n Edition Date: " + getEditorial() +
								"\n Authors: ";
		for (int i = 0; i < getAuthors().length; i++) {
			detailMagazine += "\t" + getAuthors()[i] + " ";
		}
		return  detailMagazine;
	}
	
	public static ArrayList<Magazine> makeMagazineList() {
		ArrayList<Magazine> magazines = new ArrayList();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		for (int i = 1; i <= 5; i++) {
			magazines.add(new Magazine("Magazine " + i, new Date(), "Editorial " + i));
		}
		
		return magazines;
	}

}
