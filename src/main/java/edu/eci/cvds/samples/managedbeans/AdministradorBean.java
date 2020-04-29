package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.servicios.IniciativasFactory;

@ManagedBean(name="adminBean")
@ApplicationScoped
public class AdministradorBean implements Serializable{

	private static final long serialVersionUID = 1L;

	int id;
	EstadoIniciativa estado;
	int indice;
	TipoRol rol;
	String clave;
	Usuario selectedUser;
	Iniciativa selectedIniciativa;
	String nombreSelectedIniciativa;
	String nombreUsuarioSelectedIniciativa;
	EstadoIniciativa estadoSelectedIniciativa;
	String nombreSelectedUser;

	int usuarioProponente;
	TipoRol rolSelectedUser;
	int idIniciativa;
	int votosIniciativa;
	
	public int getIdIniciativa() {
		return idIniciativa;
	}

	ArrayList<Integer> list;
	ArrayList<Integer> lon;
	ArrayList<TipoRol> roles;

	public void setSelectedIniciativa(Iniciativa selectedIniciativa) {
		this.idIniciativa = selectedIniciativa.getId();
		this.votosIniciativa = selectedIniciativa.getNumeroVotos();
		this.nombreSelectedIniciativa = selectedIniciativa.getNombre();
		this.estadoSelectedIniciativa = selectedIniciativa.getEstado();
		this.usuarioProponente = selectedIniciativa.getProponente();
		this.nombreUsuarioSelectedIniciativa = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarioPorId(this.usuarioProponente).getNombre();
	}
	
	public void cambiarIniciativa(){
		addMessage("Cambiar estado", "Cambios realizados");
		IniciativasFactory.instancia().serviciosIniciativas().actualizarIniciativa(estado,idIniciativa);
	}


	int lis;
	public void setEstado(EstadoIniciativa estado) {
		this.estado = estado;
	}

	int longitud;
	public int getLongitud(){
		return longitud;
	}
	public int getLis(){
		return lis;
	}
	@PostConstruct
	public void init() {

		longitud = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios().size();
		lis = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas().size();

		lon = new ArrayList<Integer>();
		list = new ArrayList<Integer>();

		for(int i=1; i<lis+1; i++) {
			lon.add(i);
		}

		for(int i=1; i<longitud+1; i++) {
			list.add(i);
		}
		roles = new ArrayList<TipoRol>();
		roles.add(TipoRol.Administrador);
		roles.add(TipoRol.PMO_ODI);
		roles.add(TipoRol.proponenteIniciativa);
		roles.add(TipoRol.usuarioConsulta);
	}

	public TipoRol getRol() {
		return rol;
	}

	public void setRol(TipoRol rol) {
		this.rol = rol;
	}

	public List<Iniciativa> getClave(){
		return IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
	}

	public void actualizarPerfil() {
		IniciativasFactory.instancia().serviciosIniciativas().actualizarPerfil(indice,rol);
		addMessage("Actualizar Perfil", "Cambios realizados");
		System.out.println(indice);
	}


	public EstadoIniciativa getEstado(){
		return estado;
	}

	public Integer getId(){
		return id;
	}

	public ArrayList<TipoRol> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<TipoRol> roles) {
		this.roles = roles;
	}

	public int getIndice() {
		return indice;
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public ArrayList<Integer> getLon() {
		return lon;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}	

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public void setSelectedUser(Usuario user) {
		this.indice = user.getId();
		this.nombreSelectedUser = user.getNombre();
		this.rolSelectedUser= user.getRol();
	}
	
	
	public String getNombreSelectedUser() {
		return nombreSelectedUser;
	}


	public TipoRol getRolSelectedUser() {
		return rolSelectedUser;
	}

	private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public int getVotosIniciativa() {
		return votosIniciativa;
	}

	public void setVotosIniciativa(int votosIniciativa) {
		this.votosIniciativa = votosIniciativa;
	}
	
	public String getNombreSelectedIniciativa() {
		return nombreSelectedIniciativa;
	}

	public String getNombreUsuarioSelectedIniciativa() {
		return nombreUsuarioSelectedIniciativa;
	}

	public EstadoIniciativa getEstadoSelectedIniciativa() {
		return estadoSelectedIniciativa;
	}

	public int getUsuarioProponente() {
		return usuarioProponente;
	}


	
	

}
