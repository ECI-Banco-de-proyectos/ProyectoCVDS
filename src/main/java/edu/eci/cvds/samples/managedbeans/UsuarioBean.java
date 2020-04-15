package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;


import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.impl.ServiciosIniciativasImpl;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;
import org.apache.shiro.config.Ini;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int id;
	String contraseña;
	String nombre;
	TipoRol rol;
	String mensajeErrorLogin = "";
	List<Usuario> lista;
	List<Iniciativa> lista2;
	
	public String getMensajeErrorLogin() {
		return mensajeErrorLogin;
	}
	public void setMensajeErrorLogin(String mensajeErrorLogin) {
		this.mensajeErrorLogin = mensajeErrorLogin;
	}
	public int getId() {
		return id;
	}
	public List<Usuario> getLista() {
		//cargar();
		lista = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios();
		return lista;
	}

	public List<Iniciativa> getLista2(){
		lista2=IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
		return lista2;
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

	public void insertarUsuario() {
		ServiciosIniciativas ser = IniciativasFactory.instancia().serviciosIniciativas();
		ser.insertarUsuario(contraseña, nombre, rol);
	}
	public String validar() {
		
		ServiciosIniciativas ser = IniciativasFactory.instancia().serviciosIniciativas();
		boolean in = false;
		String dir = "";
		TipoRol rolV = null;
		for(Usuario s: ser.consultarUsuarios()) {
			boolean res = s.getNombre().equals(nombre) && s.getContraseña().equals(contraseña);
			if(res) {
				in = true;
				rolV = s.getRol();
			}
		}
		
		if(!in) {
			setMensajeErrorLogin("El usuario no existe");
			dir = "inexistente";
			
		}else {
			if(rolV.equals(TipoRol.Administrador)) {
				setMensajeErrorLogin(" ");
				dir = "Administrador.xhtml?faces-redirect=true";
			}else if(rolV.equals(TipoRol.proponenteIniciativa)) {
				setMensajeErrorLogin(" ");
				dir = "Proponente.xhtml?faces-redirect=true";
			}
		}
		return dir;

	}
	
	

}
