package edu.eci.cvds.samples.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;

@ManagedBean(name="comunBean")
@ApplicationScoped

public class ComunBean {
	String clave;
	String columna;
	public int idIniciativa;
	public TipoArea areaConocimiento;
	public boolean bandera;
	ArrayList<TipoArea> areas;
	List<Iniciativa> lista;

	@PostConstruct
	public void init() {
		clave = "";
		columna = "id";
		areas = new ArrayList<TipoArea>();
		areas.add(TipoArea.Artes);
		areas.add(TipoArea.Fisica);
		areas.add(TipoArea.Matematicas);
		areas.add(TipoArea.Gerencia);
		areas.add(TipoArea.Mecanica);
		areas.add(TipoArea.Robotica);
		areas.add(TipoArea.Sistemas);
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
	public boolean isBandera() {
		return bandera;
	}
	public String getColumna(){	return columna; }
	public void setColumna(String columna){ this.columna=columna;}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getIdIniciativa() {
		return idIniciativa;
	}
	public void setIdIniciativa(int idIniciativa) {
		this.idIniciativa = idIniciativa;
	}
	public TipoArea getAreaConocimiento() {
		return areaConocimiento;
	}
	public void setAreaConocimiento(TipoArea areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}
	public ArrayList<TipoArea> getAreas() { return areas;  }
	public void setAreas(ArrayList<TipoArea> areas) { this.areas = areas; }

	public void banderaFa(){
		this.bandera=false;
	}
	public void banderaTr(){
		this.bandera=true;
	}
	public List<Iniciativa> consultarIniciativasPalabraClave(){
		System.out.println(bandera);
		System.out.println(areaConocimiento);
		if(bandera){
			//System.out.println(ini.getNombre());
			System.out.println("I am here");
			return agrupar();
		}else{
			return IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativasPalabraClave(clave);
		}
	}

	public List<Iniciativa> ordenarBusqueda(){
		return IniciativasFactory.instancia().serviciosIniciativas().ordenandoIniciativas(columna);
	}

	public List<Iniciativa> agrupar() {

		List<Iniciativa> res= new ArrayList<Iniciativa>();

		lista = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();

		for(Iniciativa ini:lista){

			int temp=ini.getId();
			if(buscar(temp)){
				res.add(ini);
			}
		}
		return res;
	}

	public boolean buscar(int ini){
		List<AreaIniciativa> ser = IniciativasFactory.instancia().areaIniciativaPersistencia().selectAreaIniciativa();
		for(AreaIniciativa i: ser){
			if(i.getIdIniciativa()==ini && i.getAreaConocimiento().equals(areaConocimiento)){
				return true;
			}
		}
		return false;
	}

	
}
