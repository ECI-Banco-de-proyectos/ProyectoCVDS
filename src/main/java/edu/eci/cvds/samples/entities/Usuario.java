package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	public int id;
	public String contraseña;
	public String nombre;
	public TipoRol rol;
	
	public Usuario(int id, String contraseña, String nombre, TipoRol rol) {
		this.id = id;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.rol = rol;
	}
	
	public Usuario() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoRol getRol() {
		return rol;
	}
	public void setRol(TipoRol rol) {
		this.rol = rol;
	}
}