package com.jacaranda.mensaje;

import java.time.LocalDateTime;
import java.util.Objects;


public class Mensaje implements Comparable<Mensaje> {


	
	private String remitente;
	private String destinatario;
	private String texto;
	private LocalDateTime fechaHora;
	public Mensaje(String remitente, String destinatario, String texto) {
		super();
		this.remitente = remitente;
		this.destinatario=destinatario;
		this.texto = texto;
		this.fechaHora = LocalDateTime.now();
	}
	public String getRemitente() {
		return remitente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public String getTexto() {
		return texto;
	}
	public LocalDateTime getFechaHora() {
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
		Mensaje other = (Mensaje) obj;
		return Objects.equals(fechaHora, other.fechaHora);
	}

	
	
	
	@Override
	public String toString() {
		return "Mensaje [remitente=" + remitente + ", destinatario=" + destinatario + ", texto=" + texto
				+ ", fechaHora=" + fechaHora + "]";
	}
	@Override
	public int compareTo(Mensaje o) {
		if (o==null) {
			return -1;
		}
		return this.fechaHora.compareTo(o.fechaHora);
	}
	
	
	
}
