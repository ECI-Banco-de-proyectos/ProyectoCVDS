package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.services.impl.ServiciosIniciativasImpl;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;

@ManagedBean(name="adminBean")
@RequestScoped
public class AdministradorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	int indice;
	TipoRol rol;
	public TipoRol getRol() {
		return rol;
	}



	public void setRol(TipoRol rol) {
		this.rol = rol;
	}

	ArrayList<Integer> list;
	ArrayList<TipoRol> roles;
	
	@PostConstruct
	public void init() {
		int longitud = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios().size();
		list = new ArrayList<Integer>();
		for(int i=1; i<longitud+1; i++) {
			list.add(i);
		}
		
		roles = new ArrayList<TipoRol>();
		roles.add(TipoRol.Administrador);
		roles.add(TipoRol.PMO_ODI);
		roles.add(TipoRol.proponenteIniciativa);
		roles.add(TipoRol.usuarioConsulta);
	}
	
	
	
	public void actualizarPerfil() {
		IniciativasFactory.instancia().serviciosIniciativas().actualizarPerfil(indice,rol);   
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

	public void setList(ArrayList list) {
		this.list = list;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

}
