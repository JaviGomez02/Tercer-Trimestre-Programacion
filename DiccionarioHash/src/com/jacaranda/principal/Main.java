package com.jacaranda.principal;

import com.jacaranda.diccionario.Diccionario;

public class Main {

	public static void main(String[] args) {

		Diccionario d=new Diccionario();
		d.annadirPalabra("Avion", "objeto que vuela");
		System.out.println(d.toString());
		System.out.println(d.mostrarPalabra("Avion"));
		d.annadirPalabra("Coche", "objeto que anda");
		d.borrarPalabra("Avion");
		System.out.println(d.toString());
		System.out.println(d.mostrarPalabraEmpieza("Co"));
		d.borrarSignificado("Coche", "objeto que anda");
		System.out.println(d.toString());
		
		
	}

}
