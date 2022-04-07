package com.jacaranda.historial;

import java.util.ArrayList;
import java.util.Iterator;

import com.jacaranda.Pagina.Pagina;
import com.jacaranda.Pagina.PaginaException;

public class Historial {
	private ArrayList<Pagina> paginas;
	public Historial() {
		super();
		this.paginas=new ArrayList<>();
	}

	
	
	public void nuevaPagina(String url) throws HistorialException {
		Pagina p;
		try {
			p=new Pagina(url);
			
		} catch (PaginaException e) {
			throw new HistorialException("La pagina no se ha podido crear");
		}
		paginas.add(p);
	}
	public String consultarHistorial() {
		StringBuilder resultado=new StringBuilder("");
		Iterator<Pagina> iterador=paginas.iterator();
		while (iterador.hasNext()) {
			Pagina p=iterador.next();
			resultado.append(p+"\n");
		}
		return resultado.toString();
	}
	public void borrarHistorial() {
		paginas.removeAll(paginas);
	}
	
	
	
	
	
}
