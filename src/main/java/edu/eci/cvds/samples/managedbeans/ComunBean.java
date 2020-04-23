package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.servicios.IniciativasFactory;

@ManagedBean(name="comunBean")
@ApplicationScoped

public class ComunBean {
	String clave;

	@PostConstruct
	public void init() {
		clave = "";
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public List<Iniciativa> consultarIniciativasPalabraClave(){
		return IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativasPalabraClave(clave);
	}
	
	
}
