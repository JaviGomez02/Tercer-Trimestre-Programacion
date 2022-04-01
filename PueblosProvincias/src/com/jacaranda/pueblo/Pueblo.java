package com.jacaranda.pueblo;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo> {

	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	public Pueblo(String nombre, String codigo) throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.numeroHabitantes=0;
		this.rentaPerCapita=0;
		this.superficie=0;
	}
	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) throws PuebloException {
		super();
		this.nombre = nombre;
		setCodigo(codigo);
		setNumeroHabitantes(numeroHabitantes);
		setRentaPerCapita(rentaPerCapita);
		setSuperficie(superficie);
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
	
	private void setCodigo(String codigo) throws PuebloException {
		if (codigo.length()!=5 ) {
			throw new PuebloException("El código debe tener una longitud de 5 caracteres");
		}
		for (int i = 0; i < codigo.length(); i++) {
			char caracter=codigo.charAt(i);
			if (!Character.isDigit(caracter)) {
				throw new PuebloException("El codigo solo puede tener caracteres numericos");
			}
		}
		this.codigo = codigo;
	}
	
	public int getNumeroHabitantes() {
		
		return numeroHabitantes;
	}
	
	public void setNumeroHabitantes(int numeroHabitantes) throws PuebloException {
		if (numeroHabitantes<0) {
			throw new PuebloException("No puede haber menos de 0 habitantes");
		}
		this.numeroHabitantes = numeroHabitantes;
	}
	
	public double getRentaPerCapita() {
		return rentaPerCapita;
	}
	
	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if (rentaPerCapita<=0) {
			throw new PuebloException("La renta per capita debe ser mayor que 0");

		}
		this.rentaPerCapita = rentaPerCapita;
	}
	
	public double getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(double superficie) throws PuebloException {
		if (superficie<=0) {
			throw new PuebloException("La superficie debe ser mayor que 0");

		}
		this.superficie = superficie;
	}
	
	public String getNombre() {
		return nombre;
	}
	@Override
	public int compareTo(Pueblo o) {
		
		return this.nombre.compareTo(o.nombre);
	}
	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}

	
	
	
}
