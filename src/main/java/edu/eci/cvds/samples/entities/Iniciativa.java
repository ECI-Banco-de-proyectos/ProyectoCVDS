package edu.eci.cvds.samples.entities;

import java.sql.Date;

public class Iniciativa {
	
	public int id;
	public String nombre;
	public String descripcion;
	public Date fecha;
	public int proponente;
	public String palabrasClave;
	public EstadoIniciativa estado;
	public int numeroVotos;
	
	public Iniciativa() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public EstadoIniciativa getEstado() {
		return estado;
	}
	public void setEstado(EstadoIniciativa estado) {
		this.estado = estado;
	}
	public int getNumeroVotos() {
		return numeroVotos;
	}
	public void setNumeroVotos(int numeroVotos) {
		this.numeroVotos = numeroVotos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getProponente() {
		return proponente;
	}
	public void setProponente(int proponente) {
		this.proponente = proponente;
	}
	public String getPalabrasClave() {
		return palabrasClave;
	}
	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
	public Iniciativa(int id, String nombre, String descripcion, Date fecha, int proponente, String palabrasClave,
			EstadoIniciativa estado, int numeroVotos) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.proponente = proponente;
		this.palabrasClave = palabrasClave;
		this.estado = estado;
		this.numeroVotos = numeroVotos;
	}

	
	
	

}
