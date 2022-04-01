package com.jacaranda.Provincia;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import com.jacaranda.pueblo.Pueblo;
import com.jacaranda.pueblo.PuebloException;

public class Provincia {

	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private HashSet<Pueblo> lista;
	
	
	public Provincia(String nombre, String codigo) throws ProvinciaException{
		super();
		if (nombre==null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.numeroHabitantes=0;
		this.rentaPerCapita=0;
		this.superficie=0;
		this.lista=new HashSet<>();
	}
	
	private boolean existePueblo(String nombre) {
		boolean resultado=false;
		Iterator<Pueblo> iterator = lista.iterator();
		while (iterator.hasNext() && !resultado) {
			Pueblo p2 =iterator.next();
			if (p2.getNombre().equals(nombre)) {
				resultado=true;
			}
		}
		return resultado;
	}
	
	
	public boolean addPueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) throws ProvinciaException {
		if (nombre==null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
		if (existePueblo(nombre.toUpperCase())) {
			throw new ProvinciaException("El nombre ya existe");
		}
		if (codigo.length()!=3) {
			throw new ProvinciaException("El código solo puede tener 3 caracteres");
		}
		boolean resultado=true;
		codigo=this.codigo.concat(codigo);
		
		Pueblo p;
		try {
			p = new Pueblo(nombre.toUpperCase(), codigo, numeroHabitantes, rentaPerCapita, superficie);
		} catch (PuebloException e) {
			throw new ProvinciaException(e.getMessage());
		}
		
		if (!lista.add(p)) {
			throw new ProvinciaException("El codigo ya existe");
		}
		this.superficie=this.superficie+p.getSuperficie();
		this.numeroHabitantes=this.numeroHabitantes+p.getNumeroHabitantes();
		this.rentaPerCapita=this.rentaPerCapita+p.getRentaPerCapita();
		
		
		return resultado;
	}
	
	
	private void setCodigo(String codigo) throws ProvinciaException {
		if (codigo==null) {
			throw new ProvinciaException("El código no puede ser nulo");
		}
		if (codigo.length()!=2 ) {
			throw new ProvinciaException("El código debe tener una longitud de 2 caracteres");
		}
		for (int i = 0; i < codigo.length(); i++) {
			char caracter=codigo.charAt(i);
			if (!Character.isDigit(caracter)) {
				throw new ProvinciaException("El codigo solo puede tener caracteres numericos");
			}
		}
		this.codigo=codigo;
	}
	
	public String listadoNombresPueblos() {
		StringBuilder resultado=new StringBuilder("");
		for (Iterator<Pueblo> iterator = lista.iterator(); iterator.hasNext();) {
			Pueblo p =iterator.next();
			resultado.append(p.getNombre()+"\n");
			
		}
		return resultado.toString();
	}

	public String listadoPueblos() {
		StringBuilder resultado=new StringBuilder("");
		for (Iterator<Pueblo> iterator = lista.iterator(); iterator.hasNext();) {
			Pueblo p =iterator.next();
			resultado.append(p.toString()+"\n");
			
		}
		return resultado.toString();
	}
	
	public boolean delPueblo(String nombre) {
		boolean resultado=false;
		Iterator<Pueblo> iterator = lista.iterator();
		while(iterator.hasNext() && !resultado) {
			Pueblo p =iterator.next();
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				resultado=true;
				lista.remove(p);
				this.superficie=this.superficie-p.getSuperficie();
				this.numeroHabitantes=this.numeroHabitantes-p.getNumeroHabitantes();
				this.rentaPerCapita=this.rentaPerCapita-p.getRentaPerCapita();
			}
			
		}
		return resultado;
		
		
		
	}
	
	public int numPueblos() {
		return this.lista.size();
	}
	
	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public boolean setNumeroHabitantes(String pueblo, int numeroHabitantes) throws ProvinciaException{
		boolean resultado=false;
		Iterator<Pueblo> iterator = lista.iterator();
		while ( iterator.hasNext() && !resultado) {
			Pueblo p = iterator.next();
			if (p.getNombre().equals(pueblo.toUpperCase())) {
				this.numeroHabitantes=this.numeroHabitantes-p.getNumeroHabitantes();
				try {
					p.setNumeroHabitantes(numeroHabitantes);
				} catch (PuebloException e) {
					throw new ProvinciaException(e.getMessage());
				}
				this.numeroHabitantes=this.numeroHabitantes+numeroHabitantes;
				resultado=true;
			}
			
		}
		return resultado;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws ProvinciaException {
		if (rentaPerCapita<0) {
			throw new ProvinciaException("La Renta Per Capita no puede ser negativa");
		}
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public boolean setSuperficie(String pueblo, double superficie) throws ProvinciaException  {
		boolean resultado=false;
		Iterator<Pueblo> iterator = lista.iterator();
		while ( iterator.hasNext() && !resultado) {
			Pueblo p = iterator.next();
			if (p.getNombre().equals(pueblo.toUpperCase())) {
				try {
					p.setSuperficie(superficie);
				} catch (PuebloException e) {
					throw new ProvinciaException(e.getMessage());
				}
				this.superficie=this.superficie+superficie;
				resultado=true;
			}
			
		}
		return resultado;
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}
	public String getInformacionPueblo(String nombre) {
		String resultado=null;
		boolean salir=false;
		Iterator<Pueblo> iterator = lista.iterator();
		while ( iterator.hasNext() && !salir) {
			Pueblo pueblo = (Pueblo) iterator.next();
			if (pueblo.getNombre().equalsIgnoreCase(nombre)) {
				resultado=pueblo.toString();
				salir=true;
			}
		}
		return resultado;
	}
	
	
	

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
	
	
}
