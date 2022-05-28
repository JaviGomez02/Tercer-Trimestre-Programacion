package com.jacaranda.diccionario;

import java.util.HashMap;
import java.util.HashSet;

public class Diccionario {
	private HashMap<String, HashSet<String>> palabras;

	public Diccionario() {
		super();
		this.palabras = new HashMap<>();
	}

	public boolean annadirPalabra(String palabra, String significado) {
		boolean resultado = true;

		HashSet<String> valor = this.palabras.get(palabra);
		if (valor == null) {
			HashSet<String> significados = new HashSet<>();
			significados.add(significado);
			if (this.palabras.put(palabra, significados) == null)
				resultado = false;
		} else {
			resultado = valor.add(significado);
		}
		return resultado;
	}

	public boolean borrarPalabra(String palabra) {
		boolean resultado = false;
		if (this.palabras.containsKey(palabra)) {
			this.palabras.remove(palabra);
			resultado = true;
		}
		return resultado;
	}

	public boolean borrarSignificado(String palabra, String significado) {
		boolean resultado = this.palabras.get(palabra).remove(significado);
		return resultado;
	}

	public String mostrarPalabra(String palabra) {
		String resultado = "Palabra no encontrada";
		if (palabras.containsKey(palabra)) {
			resultado = palabra + ": " + palabras.get(palabra).toString();
		}
		return resultado;
	}

	public String mostrarPalabraEmpieza(String cadena) {
		StringBuilder resultado = new StringBuilder("");
		for (String siguiente : this.palabras.keySet()) {
			if (siguiente.startsWith(cadena)) {
				resultado.append(siguiente + "\n");
			}
		}
		return resultado.toString();
	}

	@Override
	public String toString() {
		return "Diccionario [palabras=" + palabras + "]";
	}
	

}
