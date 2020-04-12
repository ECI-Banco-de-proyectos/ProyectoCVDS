package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import edu.eci.cvds.servicios.IniciativasFactory;

@ManagedBean(name="adminBean")
@RequestScoped
public class AdministradorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	String indice;
	ArrayList<Integer> list;
	
	@PostConstruct
	public void init() {
		int longitud = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios().size();
		int first = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios().get(0).getId();
		int last = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios().get(longitud-1).getId();
		list = new ArrayList<Integer>();
		for(int i=first; i<last+1; i++) {
			list.add(i);
		}
	}
	
	
	
	public String getIndice() {
		return indice;
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

}
