package com.amazonviewer.model;

import java.util.*;

//Solo puede entrar a ver el catálogo y no se pueden leer
public class Magazine extends Publication {
	
	private int id;
	
	public Magazine(String title, Date editionDate, String editorial) {
		super(title, editionDate, editorial);
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return "\n :: MAGAZINE ::" +
			    "\n Title: " + getTitle() +
			    "\n Editiorial: " + getEditorial() +
			    "\n Edition Date: " + getEditorialDate();
	}

}
