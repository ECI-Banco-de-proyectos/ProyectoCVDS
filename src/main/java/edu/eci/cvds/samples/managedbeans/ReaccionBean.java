package edu.eci.cvds.samples.managedbeans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.shiro.config.Ini;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Reaccion;
import edu.eci.cvds.samples.entities.UsuarioIniciativas;
import edu.eci.cvds.servicios.IniciativasFactory;


@ManagedBean(name="reaccionBean")
@ApplicationScoped
public class ReaccionBean {
	public int id_iniciativa;
	public int id_usuario;
	public String nombre;
	public String comentario;
	public Date fecha;
	public boolean voto;
	public Reaccion reaccion;
	public Iniciativa iniciativaSeleccionada;

	@PostConstruct
	public void init() {
		fecha=Date.valueOf(LocalDate.now());
	}

	
	public void insertReaccion (String nombre,String contraseña,int id_ini,int id) {
		if (comentario==""){

			addMessage("Error al insertar", "El comentario no puede ser vacio");
		}
		else {
			IniciativasFactory.instancia().serviciosIniciativas().insertarReacciones(id_ini, nombre, comentario, fecha);
			//actualizarIniciativa(id,voto+this.voto);
			int userId = IniciativasFactory.instancia().serviciosIniciativas().consultarIdPorNombreyContraseña(nombre, contraseña);
			boolean votado = votoPresente(userId, id);
			if (voto && !votado) {
				IniciativasFactory.instancia().serviciosIniciativas().insertarUsuarioIniciativa(userId, id, 1);
			} else if (!voto && votado) {
				IniciativasFactory.instancia().serviciosIniciativas().deleteUsuarioIniciativa(userId, id_ini);
			}
			addMessage("Insertar reaccion", "Reaccion insertada");

		}
	}
	
	private boolean votoPresente(int user, int iniciativa) {
		boolean res = false;
		for(UsuarioIniciativas ui: IniciativasFactory.instancia().serviciosIniciativas().selectUsuarioIniciativas()) {
			if(ui.getUsuario() == user && ui.getIniciativa() == iniciativa) {
				res = true;
			}
		}
		return res;
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
	public boolean isVoto() {
		return votoPresente(this.id_usuario,this.id_iniciativa);
	}
	public void setVoto(boolean voto) {
		this.voto = voto;
	}
	public void setIniciativaSeleccionada(Iniciativa iniciativaSeleccionada) {
		this.id_iniciativa=iniciativaSeleccionada.getId();
	}

	public void addMessage() {
		String summary = voto ? "Like" : "Dislike";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}

}
