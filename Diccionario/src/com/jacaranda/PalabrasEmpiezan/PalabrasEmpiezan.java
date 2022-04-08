package com.jacaranda.PalabrasEmpiezan;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
		while (iterador.hasNext() && !salir) {
			Palabra p=iterador.next();
			if (p.getPalabra().equals(palabra)) {
				salir=true;
				this.palabras.remove(p);
			}
		}
	}
	public void annadirSignificado(String palabra, String significado) throws PalabrasEmpiezanException {
		boolean salir=false;
		Iterator<Palabra> iterador=this.palabras.iterator();
		while (iterador.hasNext() && !salir) {
			Palabra p=iterador.next();
			if (p.getPalabra().equals(palabra)) {
				salir=true;
				try {
					p.addSignificado(significado);
				} catch (PalabraException e) {
					throw new PalabrasEmpiezanException("No se puede añadir el significado");
				}
			}
		}
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(letra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabrasEmpiezan other = (PalabrasEmpiezan) obj;
		return letra == other.letra;
	}

	@Override
	public String toString() {
		return "Letra: " + letra + ". Palabras: " + palabras;
	}

	
	
	

}
