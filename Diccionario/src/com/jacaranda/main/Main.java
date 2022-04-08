package com.jacaranda.main;

import com.jacaranda.Palabra.Palabra;
import com.jacaranda.Palabra.PalabraException;
import com.jacaranda.PalabrasEmpiezan.PalabrasEmpiezan;
import com.jacaranda.PalabrasEmpiezan.PalabrasEmpiezanException;
import com.jacaranda.diccionario.Diccionario;
import com.jacaranda.diccionario.DiccionarioException;

public class Main {

	public static void main(String[] args){

		
		Diccionario d1=new Diccionario();

		try {
			d1.annadirPalabra("Juan", "Nombre de persona");
			d1.annadirPalabra("Javi", "Nombre de persona");
			d1.annadirSignificado("Juan", "Nombre propio");
		} catch (DiccionarioException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println(d1.listarDiccionario());
	}
}
