package com.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	/**
	 * Este m�todo captura el tiempo de inicio de visualizaci�n
	 * 
	 * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @return {@code Date} Devuelve la fecha y hora capturada.
	 *
	 */
	Date startToSee(Date dateI);
	/**
	 * Este m�todo captura el tiempo de inicio y final de visualizaci�n
	 * 
	 * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @param dateF Es un objeto {@code Date} con el tiempo final exacto.
	 *
	 */
	void stopToSee(Date dateI, Date dateF);
		
}


