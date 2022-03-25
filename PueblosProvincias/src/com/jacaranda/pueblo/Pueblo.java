package com.jacaranda.pueblo;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo>{

	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	public Pueblo(String nombre, String codigo) throws PuebloException {
		super();
		if (codigo.length()!=5 ) {
			throw new PuebloException("El código debe tener una longitud de 5 caracteres");
		}
		
		this.nombre = nombre.toUpperCase();
		this.codigo = codigo;
		this.numeroHabitantes=0;
		this.rentaPerCapita=0;
		this.superficie=0;
	}
	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.numeroHabitantes = numeroHabitantes;
		this.rentaPerCapita = rentaPerCapita;
		this.superficie = superficie;
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
		Pueblo other = (Pueblo) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	private String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public int getNumeroHabitantes() {
		
		return numeroHabitantes;
	}
	
	public void setNumeroHabitantes(int numeroHabitantes) throws PuebloException {
		if (this.numeroHabitantes<0) {
			throw new PuebloException("No puede haber menos de 0 habitantes");
		}
		this.numeroHabitantes = numeroHabitantes;
	}
	
	public double getRentaPerCapita() {
		return rentaPerCapita;
	}
	
	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if (this.rentaPerCapita<=0) {
			throw new PuebloException("La renta per capita debe ser mayor que 0");

		}
		this.rentaPerCapita = rentaPerCapita;
	}
	
	public double getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(double superficie) throws PuebloException {
		if (this.superficie<=0) {
			throw new PuebloException("La superficie debe ser mayor que 0");

		}
		this.superficie = superficie;
	}
	
	public String getNombre() {
		return nombre;
	}
	@Override
	public int compareTo(Pueblo o) {
		int resultado=this.nombre.compareTo(o.nombre);
		
		return resultado;
	}
	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}

	
	
	
}
