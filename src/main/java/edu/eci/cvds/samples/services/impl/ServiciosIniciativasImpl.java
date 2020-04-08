package edu.eci.cvds.samples.services.impl;

import java.util.List;

import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;

public class ServiciosIniciativasImpl implements ServiciosIniciativas {

	@Override
	public List<Usuario> consultarUsuariosPorContraseña(String contraseña) {
		return IniciativasFactory.instancia().usuarioImplementado().consultarUsuarios(contraseña);
	}

	@Override
	public void insertarUsuario(String contraseña, String nombre, TipoRol rol) {
		int ultimoId = consultarUsuarios().get(consultarUsuarios().size()-1).id;
		IniciativasFactory.instancia().usuarioImplementado().insertarUsuario(ultimoId+1, contraseña, nombre, rol);

	}

	@Override
	public List<Usuario> consultarUsuarios() {
		return IniciativasFactory.instancia().usuarioImplementado().getUsuario();
	}
}
