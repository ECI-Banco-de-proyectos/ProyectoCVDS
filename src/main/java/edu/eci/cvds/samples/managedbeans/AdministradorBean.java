package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.servicios.IniciativasFactory;

@ManagedBean(name="adminBean")
@RequestScoped
public class AdministradorBean implements Serializable{

	private static final long serialVersionUID = 1L;

	int id;
	EstadoIniciativa estado;
	int indice;
	TipoRol rol;
	String clave;

	ArrayList<Integer> list;
	ArrayList<Integer> lon;
	ArrayList<TipoRol> roles;

	int lis;
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
		System.out.println(estado);
		System.out.println(indice);
		IniciativasFactory.instancia().serviciosIniciativas().actualizarPerfil(indice,rol);
	}

	public void cambiarIniciativa(){
		System.out.println(estado);
		System.out.println(indice);
		IniciativasFactory.instancia().serviciosIniciativas().actualizarIniciativa(estado,indice);
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

}
