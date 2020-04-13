package edu.eci.cvds.samples.services.impl;

import java.util.List;

import javax.faces.bean.ApplicationScoped;

import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;

@ApplicationScoped
public class ServiciosIniciativasImpl implements ServiciosIniciativas {

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
}
