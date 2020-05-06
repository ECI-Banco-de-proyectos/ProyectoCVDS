package edu.eci.cvds.samples.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.persistencia.DAOIniciativa;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;


public class ServiciosIniciativasImpl implements ServiciosIniciativas {

	@Override
	public DAOIniciativa buscarIniciativas(String clave) {
		return IniciativasFactory.instancia().iniciativaImplementado().claveIniciativa(clave);
	}

	@Override
	public List<Usuario> consultarUsuariosPorContraseña(String contraseña) {
		return IniciativasFactory.instancia().usuarioImplementado().consultarUsuarios(contraseña);
	}

	@Override
	public void insertarUsuario(String contraseña, String nombre, TipoRol rol, String area) {
		int ultimoId = consultarUsuarios().size();
		IniciativasFactory.instancia().usuarioImplementado().insertarUsuario(ultimoId+1, contraseña, nombre, rol, area);

	}

	@Override
	public List<Usuario> consultarUsuarios() {
		return IniciativasFactory.instancia().usuarioImplementado().getUsuario();
	}

	@Override
	public void actualizarPerfil(int id, TipoRol tipoRol) {
		IniciativasFactory.instancia().usuarioImplementado().updatePerfil(id,tipoRol);
	}

	@Override
	public void actualizarIniciativa(EstadoIniciativa estado, int id) {
		IniciativasFactory.instancia().iniciativaImplementado().cambiarIniciativa(estado,id);
	}

	@Override
	public void insertarIniciativa(int id, int usuario, String nombre, EstadoIniciativa estado, int votos, Date fecha,
			String descripcion) {
		IniciativasFactory.instancia().iniciativaImplementado().insertIniciativa(id, usuario, nombre, estado, votos, fecha, descripcion);
		
	}

	@Override
	public List<Iniciativa> consultarIniciativas() {
		return IniciativasFactory.instancia().iniciativaImplementado().selectIniciativa();
	}

	@Override
	public List<Iniciativa> consultarIniciativasPalabraClave(String word) {
		List<Iniciativa> iniciativas = consultarIniciativas();
		ArrayList<Iniciativa> temp = new ArrayList<Iniciativa>();
		String minus = word.toLowerCase();
		for(Iniciativa in: iniciativas) {
			if(in.getNombre().toLowerCase().contains(minus)) {
				temp.add(in);
			}
		}
		return temp;

	}

	@Override
	public List<Iniciativa> ordenandoIniciativas(String columnaSeleccionada) {
		return IniciativasFactory.instancia().iniciativaImplementado().ordenDeIniciativa(columnaSeleccionada);
	}

	@Override
	public void insertarReacciones(int idIni, String nombre, String comentario, Date fecha) {
		IniciativasFactory.instancia().reaccionImplementado().insertReaccion(idIni,nombre,comentario,fecha);
		
	}

	@Override
	public void actualizarIniciativasVotos(int id, int voto) {
		IniciativasFactory.instancia().reaccionImplementado().updateIniciativa(id, voto);
		
	}

	@Override
	public List<AreaIniciativa> selectAreaIniciativa() {
		return IniciativasFactory.instancia().areaIniciativaImplementado().selectAreaIniciativa();
	}

	@Override
	public Usuario consultarUsuarioPorId(int id) {
		Usuario res = null;
		for(Usuario u: consultarUsuarios()) {
			if(u.getId()==id) res=u;
		}
		return res;
	}

	@Override
	public List<PalabrasClave> consultaPalabrasClave() {
		return IniciativasFactory.instancia().palabrasClaveImplementado().consultaPalabrasClave();
	}

	@Override
	public PalabrasClave consultaPalabraClavePorId(String palabra) {
		return IniciativasFactory.instancia().palabrasClaveImplementado().consultaPalabraClavePorId(palabra);
	}

	@Override
	public void elimiarPalabraClavePorId(String palabra) {
		IniciativasFactory.instancia().palabrasClaveImplementado().elimiarPalabraClavePorId(palabra);
	}

	@Override
	public List<Area> consultarAreas() {
		return IniciativasFactory.instancia().areasImplementado().consultarAreas();
	}

	@Override
	public Area consultaAreaPorId(String id) {
		return IniciativasFactory.instancia().areasImplementado().consultaAreaPorId(id);
	}

	@Override
	public void insertarPalabraClave(String palabra, int iniciativa) {
		IniciativasFactory.instancia().palabrasClaveImplementado().insertarPalabraClave(palabra, iniciativa);
		
	}
	
}
