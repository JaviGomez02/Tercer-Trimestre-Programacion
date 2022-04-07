package com.jacaranda.main;

import com.jacaranda.Palabra.Palabra;
import com.jacaranda.Palabra.PalabraException;
import com.jacaranda.PalabrasEmpiezan.PalabrasEmpiezan;
import com.jacaranda.PalabrasEmpiezan.PalabrasEmpiezanException;

public class Main {

	public static void main(String[] args){


		
		PalabrasEmpiezan p1=new PalabrasEmpiezan('A');
		try {
			p1.addPalabra("barco", "objeto volador");
		} catch (PalabrasEmpiezanException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
