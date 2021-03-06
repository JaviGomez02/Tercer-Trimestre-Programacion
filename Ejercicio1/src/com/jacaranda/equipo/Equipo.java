package com.jacaranda.equipo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.jacaranda.jugadores.Alumno;

public class Equipo {

	public String nombre;
	private Set<Alumno> lista;
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.lista=new HashSet<Alumno>();
	}
	
	public void addAlumno(Alumno a) throws EquipoException {
		if (lista.contains(a) || a==null) {
			throw new EquipoException("Alumno ya existente o nulo");
		}
		lista.add(a);
	}
	public void borrarAlumno(Alumno a) throws EquipoException {
		if (!lista.contains(a) || a==null) {
			throw new EquipoException("Alumno no existente o nulo");
		}
		lista.remove(a);
	}
	
	private boolean borrarUnAlumno(String nombre) {
		boolean encontrado=false;
		Iterator<Alumno> siguiente=this.lista.iterator();
		while (siguiente.hasNext() && encontrado==false) {
			Alumno a = siguiente.next();
			if (a.getNombre().equals(nombre)) {
				this.lista.remove(a);
				encontrado=true;
			}
		}
		return encontrado;
	}
	
	public void borrarAlumno(String nombre) {
		
		while(borrarUnAlumno(nombre)==true);
	}

	public Alumno buscarAlumno(Alumno a) {
		Alumno resultado;
		if (!lista.contains(a)) {
			resultado=null;
		}
		else {
			resultado=a;
		}
		return resultado;
	}
	
	public String mostrarEquipo() {
		return lista.toString();
	}
	
	public Equipo unionEquipos(Equipo e) {
		Equipo nuevo=new Equipo("Equipo nuevo");
		for (Alumno a : this.lista) {
			try {
				nuevo.addAlumno(a);
			} catch (EquipoException e1) {
				//e1.printStackTrace();
			}
		}
		for (Alumno a: e.lista) { //Los alumnos repetidos no los mete en la coleccion
			try {
				nuevo.addAlumno(a);
			} catch (EquipoException e1) {
				//e1.printStackTrace();
			}
		}
		
		return nuevo;
	}
	
	public Equipo interseccionEquipos(Equipo e){
		Equipo nuevo=new Equipo("Equipo nuevo");
		for (Alumno a : lista) {
			if (e.lista.contains(a)) {
				try {
					nuevo.addAlumno(a);
				} catch (EquipoException e1) {
					//e1.printStackTrace();
				}
			}
		}
		
		return nuevo;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", lista=" + lista + "]";
	}
	
	
}
