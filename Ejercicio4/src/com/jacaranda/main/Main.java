package com.jacaranda.main;

import com.jacaranda.historial.Historial;
import com.jacaranda.historial.HistorialException;

public class Main {

	public static void main(String[] args) {


		
		Historial h=new Historial();
		
		try {
			h.nuevaPagina("google.es");
			System.out.println(h.consultarHistorial());
			h.borrarHistorial();
			System.out.println(h.consultarHistorial());
		} catch (HistorialException e) {
			System.out.println(e.getMessage());
		}
	}

}
