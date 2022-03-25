package com.jacaranda.main;

import com.jacaranda.equipo.Equipo;
import com.jacaranda.equipo.EquipoException;
import com.jacaranda.jugadores.Alumno;

public class Main {

	public static void main(String[] args) throws EquipoException {
		// TODO Auto-generated method stub

		Alumno a1=new Alumno("Julian","123");
		Equipo e1=new Equipo("Brenes");
		
		e1.addAlumno(a1);
		System.out.println(e1.mostrarEquipo());
		e1.borrarAlumno(a1);
		System.out.println(e1.mostrarEquipo());
		
		
		
	}

}
