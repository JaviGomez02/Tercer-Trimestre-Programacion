package com.jacaranda.Pagina;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Pagina {

	private String url;
	private LocalDate fecha;
	private LocalTime hora;
	
	public Pagina(String url) throws PaginaException {
		super();
		setUrl(url);
		this.fecha = LocalDate.now();
		this.hora = LocalTime.now();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) throws PaginaException {
		if (url==null) {
			throw new PaginaException("El URL no puede ser nulo");
		}
		this.url = url;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	@Override
	public int hashCode() {
		return Objects.hash(url);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagina other = (Pagina) obj;
		return Objects.equals(url, other.url);
	}
	@Override
	public String toString() {
		return "Pagina [url=" + url + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
	
	
	
}
