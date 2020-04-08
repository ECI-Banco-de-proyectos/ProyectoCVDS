package edu.eci.cvds.servicios;

import java.util.List;

import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosIniciativas {

	public List<Usuario> consultarUsuariosPorContraseña(String contraseña);
	
	public List<Usuario> consultarUsuarios();
	
	public void insertarUsuario(String contraseña, String nombre, TipoRol rol);
}
