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

import edu.eci.cvds.samples.entities.Area;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.impl.ServiciosIniciativasImpl;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;
import org.apache.shiro.config.Ini;

@ManagedBean
@ApplicationScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int id;
	String contraseña;
	String nombre;
	boolean isUsuario = false;
	TipoRol rol = TipoRol.usuarioConsulta;
	String area = "No presenta área";
	String mensajeErrorLogin = "";
	List<Usuario> lista;
	List<Iniciativa> lista2;
	List<String> areaUsuario;
	String areaU;


	@PostConstruct
	public void init() {
		List<Area> lis = IniciativasFactory.instancia().serviciosIniciativas().consultarAreas();
		areaUsuario = new ArrayList<String>();
		for(Area i: lis){
			areaUsuario.add(i.getNombre());
		}

	}
	public String getAreaU() {
		return areaU;
	}

	public void setAreaU(String areaU) {
		this.areaU = areaU;
	}

	public void setUsuario(boolean usuario) {
		isUsuario = usuario;
	}

	public List<String> getAreaUsuario() {
		return areaUsuario;
	}

	public boolean getIsUsuario() {
		return isUsuario;
	}
	
	public void conectarUsuario() {
		this.isUsuario=true;
	}
	
	public String desconectarUsuario() {
		this.isUsuario=false;
		return "logearV2.xhtml?faces-redirect=true";
	}
	
	public String getMensajeErrorLogin() {
		return mensajeErrorLogin;
	}
	public void setMensajeErrorLogin(String mensajeErrorLogin) {
		this.mensajeErrorLogin = mensajeErrorLogin;
	}
	public int getId() {
		return IniciativasFactory.instancia().serviciosIniciativas().consultarIdPorNombreyContraseña(this.nombre, this.contraseña);
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = areaUsuario(nombre, contraseña);
	}

	public void insertarUsuario() {

		addMessage("Insertar usuario", "Usuario Insertado");
		ServiciosIniciativas ser = IniciativasFactory.instancia().serviciosIniciativas();
		ser.insertarUsuario(contraseña, nombre, rol, areaU);
	}
	
	private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	
	public String validar() {
		ServiciosIniciativas serviciosIniciativas = IniciativasFactory.instancia().serviciosIniciativas();
		Usuario us;
		String redireccion = null;
		try {
			us = serviciosIniciativas.consultarUsuario(this.nombre, this.contraseña);
			if(us!=null) {
				if(us.getRol().equals(TipoRol.Administrador)) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Administrador", us);
					redireccion = "Administrador/Administrador.xhtml?faces-redirect=true";
				}else if(us.getRol().equals(TipoRol.proponenteIniciativa)) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Proponente", us);
					redireccion = "Proponente/Proponente.xhtml?faces-redirect=true";
				}else if(us.getRol().equals(TipoRol.usuarioConsulta)) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", us);
					redireccion = "Usuario/DatosIniciativa.xhtml?faces-redirect=true";
				}else if(us.getRol().equals(TipoRol.PMO_ODI)) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PMO", us);
					redireccion = "PMO/busquedaIniciativaProp.xhtml?faces-redirect=true";
				}
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
			}
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
		}
		return redireccion;
	}
	
	private TipoRol rolUsuario(String nombre, String contraseña) {
		List<Usuario> usuarios = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios();
		TipoRol res = null;
		for(Usuario u: usuarios) {
			if(u.getNombre().equals(nombre) && u.getContraseña().equals(contraseña)) {
				res = u.getRol();
			}
		}
		return res;
	}
	
	public String areaUsuario(String nombre, String contraseña) {
		List<Usuario> usuarios = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios();
		String res = null;
		for(Usuario u: usuarios) {
			if(u.getNombre().equals(nombre) && u.getContraseña().equals(contraseña)) {
				res = u.getArea();
			}
		}
		return res;
	}
	public String usuarioLogin() {
		String res = "url=logearV2.xhtml";
		if(getIsUsuario()) {
			TipoRol rol = rolUsuario(this.nombre, this.contraseña);
			if(rol.equals(TipoRol.Administrador)) {
				res = "0;url=Administrador.xhtml";
			}else if(rol.equals(TipoRol.proponenteIniciativa)) {
				res = "0;url=Proponente.xhtml";
			}else if(rol.equals(TipoRol.usuarioConsulta)){
				res = "0;url=DatosIniciativa.xhtml";
			}else if(rol.equals(TipoRol.PMO_ODI)){
				res = "0;url=busquedaIniciativaProp.xhtml";
			}
		}
		return res;
	}
	
	public void verificarSesionAdministrador() {
		try {
			Usuario administrador = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Administrador");
			if(administrador == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/Permisos.html?faces-redirect=true");
				return;
			}	
			
		}catch (Exception e) {
			
		}
	}
	
	public void verificarSesionProponente() {
		try {
			Usuario proponente = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Proponente");
			if(proponente == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/Permisos.html?faces-redirect=true");
				return;
			}	
			
		}catch (Exception e) {
			
		}
	}
	
	public void verificarSesionPMO() {
		try {
			Usuario pmo = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PMO");
			if(pmo == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/Permisos.html?faces-redirect=true");
				return;
			}	
			
		}catch (Exception e) {
			
		}
	}
	
	public void verificarSesionUsuario() {
		try {
			Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
			if(usuario == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/Permisos.html?faces-redirect=true");
				return;
			}	
			
		}catch (Exception e) {
			
		}
	}
	
	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/logearV2.xhtml?faces-redirect=true";
	}

}
