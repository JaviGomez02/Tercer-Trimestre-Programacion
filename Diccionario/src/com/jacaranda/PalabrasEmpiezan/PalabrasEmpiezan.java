package com.jacaranda.PalabrasEmpiezan;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.jacaranda.Palabra.Palabra;
import com.jacaranda.Palabra.PalabraException;

public class PalabrasEmpiezan {
	
	private char letra;
	private List<Palabra> palabras;

	public PalabrasEmpiezan(char letra) {
		super();
		this.letra = letra;
		this.palabras=new LinkedList<>();
	}

	public char getLetra() {
		return letra;
	}
	public void addPalabra(String palabra, String significado) throws PalabrasEmpiezanException {
		Palabra p;
		try {
			p = new Palabra(palabra, significado);
		} catch (PalabraException e) {
			throw new PalabrasEmpiezanException("No se puede crear la palabra");
		}
		if (p.getInicialPalabra()!=this.letra) {
			throw new PalabrasEmpiezanException("La palabra debe empezar por "+this.letra);
		}
		if (this.palabras.contains(p)) {
			throw new PalabrasEmpiezanException("La palabra ya existe");
		}
		this.palabras.add(p);	
	}
	
	public void borrarPalabra(String palabra) {
		boolean salir=false;
		Iterator<Palabra> iterador=this.palabras.iterator();
		while (iterador.hasNext() && salir==false) {
			Palabra p=iterador.next();
			if (p.getPalabra().equals(p)) {
				salir=true;
				this.palabras.remove(p);
			}
			
		}
		
		
	}
	

	@Override
	public String toString() {
		return "PalabrasEmpiezan [letra=" + letra + ", palabras=" + palabras + "]";
	}

	
	
	

}
