package com.jacaranda.Pagina;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pagina {

	private String url;
	private LocalDateTime fechaHora;
	
	public Pagina(String url) throws PaginaException {
		super();
		setUrl(url);
		this.fechaHora = LocalDateTime.now();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) throws PaginaException {
		if (url==null || url.equals("")) {
			throw new PaginaException("El URL no puede ser nulo");
		}
		this.url = url;
	}
	public LocalDateTime getFecha() {
		return fechaHora;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(fechaHora);
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
		return Objects.equals(fechaHora, other.fechaHora);
	}
	@Override
	public String toString() {
		return "Pagina [url=" + url + ", fecha=" + fechaHora +"]";
	}
	
	
	
	
	
}
