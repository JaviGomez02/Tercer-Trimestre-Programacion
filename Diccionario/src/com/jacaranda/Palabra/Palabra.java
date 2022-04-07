package com.jacaranda.Palabra;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Palabra {

	private String palabra;
	private Set<String> significados;
	public Palabra(String palabra) throws PalabraException {
		super();
		setPalabra(palabra);
		this.significados=new HashSet<>();
	}
	public Palabra(String palabra, String significado) throws PalabraException {
		super();
		setPalabra(palabra);
		this.significados = new HashSet<>();
		addSignificado(significado);
	}
	public String getPalabra() {
		return palabra;
	}
	private void setPalabra(String palabra) throws PalabraException {
		if (palabra==null || palabra.equals("")) {
			throw new PalabraException("La palabra no puede ser nula");
		}
		this.palabra = palabra;
	}
	
	public void addSignificado(String significado) throws PalabraException {
		if (significado==null || significado.equals("")) {
			throw new PalabraException("No puedes introducir un significado nulo o vacio");
		}
		if (this.significados.contains(significado)) {
			throw new PalabraException("El significado ya existe");
		}
		significados.add(significado);
	}
	
	public char getInicialPalabra() {
		return this.palabra.toUpperCase().charAt(0);
	}
	@Override
	public int hashCode() {
		return Objects.hash(palabra);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palabra other = (Palabra) obj;
		return Objects.equals(palabra, other.palabra);
	}
	@Override
	public String toString() {
		return "Palabra: " + palabra + ". Significados: " + significados;
	}
	
	
}
