package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.servicios.IniciativasFactory;

@ManagedBean(name="proBean")
public class ProponenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int id;
	int usuario;
	String nombreIniciativa;
	EstadoIniciativa estado;
	int votos;
	Date fechaInicio;
	String descripcion;

	
	
	public void insertarIniciativa(String nombre, String contraseña) {
		int ind = obtenerId(nombre, contraseña);
		id = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas().size();
		IniciativasFactory.instancia().serviciosIniciativas().insertarIniciativa(id+1, ind, nombreIniciativa, estado, 0, Date.valueOf(LocalDate.now()), descripcion);
	}

	public int obtenerId(String nombre, String contr) {
		int res = 0;
		ArrayList<Usuario> list = (ArrayList<Usuario>) IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios();
		
		for(Usuario u: list) {
			if(u.getContraseña().equals(contr) && u.getNombre().equals(nombre)) {
				res = u.getId();
			}
		}
		
		
		return res;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getNombreIniciativa() {
		return nombreIniciativa;
	}

	public void setNombreIniciativa(String nombreIniciativa) {
		this.nombreIniciativa = nombreIniciativa;
	}

	public EstadoIniciativa getEstado() {
		return estado;
	}

	public void setEstado(EstadoIniciativa estado) {
		this.estado = estado;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
