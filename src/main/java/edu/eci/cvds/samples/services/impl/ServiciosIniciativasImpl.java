package edu.eci.cvds.samples.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistencia.DAOIniciativa;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;

@ApplicationScoped
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
	public void insertarUsuario(String contraseña, String nombre, TipoRol rol) {
		int ultimoId = consultarUsuarios().size();
		IniciativasFactory.instancia().usuarioImplementado().insertarUsuario(ultimoId+1, contraseña, nombre, rol);

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
	public List<Iniciativa> ordenandoIniciativas(String clave, String columnaSeleccionada) {

		return consultarIniciativasPalabraClave(clave);
	}
}
