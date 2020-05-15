package edu.eci.cvds.samples.managedbeans;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.servicios.IniciativasFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ManagedBean(name="comunBean")
@ApplicationScoped

public class ComunBean {
	public Usuario usuario;
	String clave;
	String columna;
	public int idIniciativa;
	public TipoArea areaConocimiento;
	public int bandera=0;
	ArrayList<TipoArea> areas;
	List<Iniciativa> lista;
	List<Usuario> listaUsuarios;
	public int usu;
	public String nombreIniciativa;

	@PostConstruct
	public void init() {
		clave = "";
		columna = "id";
		areas = new ArrayList<TipoArea>();
		areas.add(TipoArea.DireccionIplusi);
		areas.add(TipoArea.Posgrados);
		areas.add(TipoArea.VicerrectoriaAdministrativa);
		areas.add(TipoArea.SecretariaGeneral);
		areas.add(TipoArea.VicerrectoriaAcademica);

	}

	public String getNombreIniciativa() {
		return nombreIniciativa;
	}

	public void setNombreIniciativa(String nombreIniciativa) {
		this.nombreIniciativa = nombreIniciativa;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setBandera(int bandera) {
		this.bandera = bandera;
	}

	public int getBandera() {
		return bandera;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

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

	public ArrayList<TipoArea> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<TipoArea> areas) {
		this.areas = areas;
	}

	public void banderaCero() {
		this.bandera = 0;
	}

	public void banderaUno() {
		this.bandera = 1;
	}

	public void banderaDos() {
		this.bandera = 2;
	}
	
	public List<Iniciativa> consultarIniciativas(){
		return IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
	}

	public List<Iniciativa> consultarIniciativasPalabraClave() {
		if (bandera==1) {
			if (TipoArea.Todas.equals(areaConocimiento)) {
				return IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativasPalabraClave("");
			} else {
				return agrupar();
			}
		}else{
			return ordenarBusqueda();
		}
	}

	public List<Iniciativa> ordenarBusqueda() {
		return IniciativasFactory.instancia().serviciosIniciativas().ordenandoIniciativas(columna);
	}

	public List<Iniciativa> ordenarBusqueda2(String name) {
		return IniciativasFactory.instancia().serviciosIniciativas().ordenandoIniciativas(name);
	}

	public List<Usuario> getLista() {
		//cargar();
		listaUsuarios = IniciativasFactory.instancia().serviciosIniciativas().consultarUsuarios();
		return listaUsuarios;
	}

	public List<Iniciativa> ordenarBusquedaProponente(String nombre) {
		List<Usuario> u = getLista();
		for (Usuario i : u) {
			if (i.getNombre().equals(nombre)) {
				usu = i.getId();
			}
		}
		List<Iniciativa> lista = ordenarBusqueda();
		List<Iniciativa> listaM = new ArrayList<Iniciativa>();
		for (Iniciativa i : lista) {
			if (i.getProponente() == usu) {
				listaM.add(i);
			}
		}
		return listaM;
	}

	public List<Iniciativa> agrupar() {

		List<Iniciativa> res = new ArrayList<Iniciativa>();
		lista = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
		for (Iniciativa ini : lista) {
			int temp = ini.getId();
			if (buscar(temp)) {
				res.add(ini);
			}
		}
		return res;
	}

	public boolean buscar(int ini) {
		List<AreaIniciativa> ser = IniciativasFactory.instancia().serviciosIniciativas().selectAreaIniciativa();
		for (AreaIniciativa i : ser) {
			if (i.getIdIniciativa() == ini && i.getAreaConocimiento().equals(areaConocimiento)) {
				return true;
			}
		}
		return false;
	}

	public String consultaPalabrasClave(int idIniciativa) {
		List<PalabrasClave> pc = IniciativasFactory.instancia().serviciosIniciativas().consultarPalabraClavePorIniciativa(idIniciativa);
		String res = "";
		for (PalabrasClave pac : pc) {
			res = res + pac.getPalabra() + "\n";
		}
		return res;
	}

	public List<String> nombreIniciativas() {
		lista = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
		List<String> nombres = new ArrayList<String>();
		for (Iniciativa i : lista) {
			nombres.add(i.getNombre());
		}
		return nombres;
	}
	
	public int palabrasClavePorIniciativa(int idInic) {
		return IniciativasFactory.instancia().serviciosIniciativas().numeroVotosPorIniciativa(idInic);
	}

	public  List<Iniciativa> selectIniciativasAgrupadas() {
		List <IniciativasAgrupadas>listaAgrupada = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativasAgrupadas();
		List <Iniciativa> salida = new ArrayList<>();
		List <Iniciativa> lista2 = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
		Set<Iniciativa> set = new HashSet<>();

		for (IniciativasAgrupadas i: listaAgrupada ){
			if (i.getNombreIniciativa().equals(nombreIniciativa)){
				for (IniciativasAgrupadas j: listaAgrupada ){
					if (i.getIniciativaAgrupada() == j.getIniciativaAgrupada() && i.getNombreIniciativa()!=j.getNombreIniciativa() ) {
						for (Iniciativa k: lista2 ){
							if (k.getNombre().equals(j.getNombreIniciativa())){
								salida.add(k);
							}
						}
					}
				}
			}
		}
		for (Iniciativa q: salida ){
			set.add(q);
		}
		List<Iniciativa> mainList = new ArrayList<>();
		mainList.addAll(set);
	return mainList;
	}

	public List<Reaccion> selectReacion(int id_ini){
		List<Reaccion> res = new ArrayList<Reaccion>();
		List<Reaccion> lis = IniciativasFactory.instancia().reaccionImplementado().selectReacciones();
		for(Reaccion i: lis){
			if(id_ini==i.getId_iniciativa()){
				res.add(i);
			}
		}
		return res;
	}

}
