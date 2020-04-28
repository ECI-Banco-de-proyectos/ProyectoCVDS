package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Reaccion implements Serializable{
	public int id_iniciativa;

	public String nombre;
	public String comentario;
	public Date fecha;
	
	
	public int getId_iniciativa() {
		return id_iniciativa;
	}
	public void setId_iniciativa(int id_iniciativa) {
		this.id_iniciativa = id_iniciativa;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
