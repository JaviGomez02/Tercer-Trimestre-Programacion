package com.jacaranda.persona;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.mensaje.Mensaje;

public abstract class Persona {

	private String nombre;
	private int edad;
	private List<Mensaje> buzon;
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.buzon=new LinkedList<Mensaje>();
	}
	public abstract void enviarMensaje(String persona, String texto);
	
	public String leerMensajes() throws PersonaException {
		if (this.buzon.isEmpty()) {
			throw new PersonaException("No hay ningún mensaje");
		}
		StringBuilder resultado=new StringBuilder();
		Iterator<Mensaje> iterador=buzon.iterator();
		while (iterador.hasNext()) {
			Mensaje m1=iterador.next();
			resultado.append("Mensaje de: "+m1.getRemitente()+" Texto: "+m1.getTexto()+"\n"+"Fecha y hora: "+m1.getFechaHora());
		}
		
		
		return resultado.toString();
	}
	
//	public String leerMensajesOrdenados() throws PersonaException {
//		if (this.buzon.isEmpty()) {
//			throw new PersonaException("No hay ningún mensaje");
//		}
//		
//		
//		
//	}
	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
	
	
	
}
