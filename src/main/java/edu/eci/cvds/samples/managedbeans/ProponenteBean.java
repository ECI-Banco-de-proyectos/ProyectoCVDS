package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.eci.cvds.samples.entities.*;
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
	String palabrasClave;
	List<Integer> idIniciativa;
	String guardarEstados;
	List<EstadoIniciativa> estados;

	@PostConstruct
	public void init() {
		idIniciativa = new ArrayList<Integer>();
		int longitud = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas().size();
		for(int i=1; i<longitud+1; i++) {
			idIniciativa.add(i);
		}

		estados=new ArrayList<EstadoIniciativa>();
		estados.add(EstadoIniciativa.En_Espera_De_Revision);
		estados.add(EstadoIniciativa.En_Revision);
		estados.add(EstadoIniciativa.Proyecto);
		estados.add(EstadoIniciativa.Solucionado);
	}


	public void insertarIniciativa(String nombre, String contraseña, TipoArea area) {
		int ind = obtenerId(nombre, contraseña);
		id = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas().size();
		if (nombreIniciativa=="" || descripcion==""){
			addMessage("Error al insertar", "El nombre de la iniciativa y la descripcion no pueden estar vacios");
		}
		else {
			IniciativasFactory.instancia().serviciosIniciativas().insertarIniciativa(id + 1, ind, nombreIniciativa, estado, 0, Date.valueOf(LocalDate.now()), descripcion);
			IniciativasFactory.instancia().serviciosIniciativas().insertarPalabraClave(palabrasClave, id + 1);
			IniciativasFactory.instancia().areaIniciativaImplementado().insertAreaIniciativa(id + 1, area);
			addMessage("Insertar iniciativa", "Iniciativa insertada");
		}
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

	public void setGuardarEstados(String guardarEstados) {
		this.guardarEstados = guardarEstados;
	}

	public String getGuardarEstados() {
		return guardarEstados;
	}

	public List<EstadoIniciativa> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoIniciativa> estados) {
		this.estados = estados;
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
	
	public List<Integer> getIdIniciativa() {
		return idIniciativa;
	}


	public void setIdIniciativa(List<Integer> idIniciativa) {
		this.idIniciativa = idIniciativa;
	}
	
	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Iniciativa> filtrarEstados(){
		List<Iniciativa> lis = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
		List<Iniciativa> res = new ArrayList<Iniciativa>();
		for(Iniciativa i: lis){
			if(i.getEstado().equals(estado)){
				res.add(i);
			}
		}
		return res;
	}

	public void onRowEdit(EstadoIniciativa es, int id, int idU, String name) {
		int usu=-1;
		if(es!=EstadoIniciativa.En_Espera_De_Revision){
			addMessage("Actualizar iniciativa", "Solo se pueden actualizar iniciativas en espera de reivisión");
		}else{
			List<Usuario> u =IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios();
			for (Usuario i : u) {
				if (i.getNombre().equals(name)) {
					usu = i.getId();
				}
			}
			if(usu==idU) {
				IniciativasFactory.instancia().iniciativaImplementado().cambiarIniciativas(nombreIniciativa, descripcion, id);
				addMessage("Actualizar iniciativa", "Iniciativa actualizada, por favor recargue la página");
			}else{
				addMessage("Actualizar iniciativa", "El usuario registrado no es quien ha creado esta iniciativa");
			}
		}
	}

	public void onRowCancel() {
		addMessage("Cancelar actualización", "Actualización cancelada");
	}
	
}
