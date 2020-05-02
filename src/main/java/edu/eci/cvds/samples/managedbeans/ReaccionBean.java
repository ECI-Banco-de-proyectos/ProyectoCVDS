package edu.eci.cvds.samples.managedbeans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.eci.cvds.samples.entities.Reaccion;
import edu.eci.cvds.servicios.IniciativasFactory;


@ManagedBean(name="reaccionBean")
public class ReaccionBean {
	public int id_iniciativa;
	public int id_usuario;
	public String nombre;
	public String comentario;
	public Date fecha;
	public int voto;
	public Reaccion reaccion;
	
	@PostConstruct
	public void init() {
		fecha=Date.valueOf(LocalDate.now());
	}

	
	public void insertReaccion (String nombre,int id_ini,int id,int voto) {
		IniciativasFactory.instancia().serviciosIniciativas().insertarReacciones(id_ini, nombre , comentario, fecha);
		actualizarIniciativa(id,voto+this.voto);
		addMessage("Insertar reaccion", "Reaccion insertada");
		
	}
	
	public void actualizarIniciativa(int id, int voto) {
		IniciativasFactory.instancia().serviciosIniciativas().actualizarIniciativasVotos(id, voto);
		addMessage("Actualizar Iniciativa", "Cambios realizados");
	}
	private void addMessage(String summary, String detail) {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	     FacesContext.getCurrentInstance().addMessage(null, message);
		
	}
	
	public int getId_iniciativa() {
		return id_iniciativa;
	}
	public void setId_iniciativa(int id_iniciativa) {
		this.id_iniciativa = id_iniciativa;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	

}
