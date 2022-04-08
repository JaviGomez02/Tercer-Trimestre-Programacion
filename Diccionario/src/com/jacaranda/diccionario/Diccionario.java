package com.jacaranda.diccionario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jacaranda.PalabrasEmpiezan.PalabrasEmpiezan;
import com.jacaranda.PalabrasEmpiezan.PalabrasEmpiezanException;

public class Diccionario {

	
	private List<PalabrasEmpiezan> letras;

	public Diccionario() {
		super();
		this.letras=new ArrayList<>();
		annadirLetras();
	}
	
	
	private void annadirLetras() {
		 for (int i = 65; i <=90; i++) {
			this.letras.add(new PalabrasEmpiezan((char)i));
		}
	}

	public void annadirPalabra(String palabra, String significado) throws DiccionarioException {
		PalabrasEmpiezan p=new PalabrasEmpiezan(palabra.toUpperCase().charAt(0));
		try {
			this.letras.get(this.letras.indexOf(p)).addPalabra(palabra, significado);
		} catch (PalabrasEmpiezanException e) {
			throw new DiccionarioException("No se puede añadir la palabra");
		}
	}

	public void annadirSignificado(String palabra, String significado) throws DiccionarioException {
		PalabrasEmpiezan p=new PalabrasEmpiezan(palabra.toUpperCase().charAt(0));
		try {
			this.letras.get(this.letras.indexOf(p)).annadirSignificado(palabra, significado);
		} catch (PalabrasEmpiezanException e) {
			throw new DiccionarioException("No se puede añadir la palabra");
		}
	}
	
	public String listarDiccionario() {
		StringBuilder resultado=new StringBuilder("");
		Iterator<PalabrasEmpiezan> iterador=letras.iterator();
		while (iterador.hasNext()) {
			PalabrasEmpiezan p=iterador.next();
			resultado.append(p+"\n");
			
		}
		return resultado.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
