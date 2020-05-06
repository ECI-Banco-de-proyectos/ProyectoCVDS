package edu.eci.cvds.samples.persistencia;

import java.util.List;

import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;

public interface DAOUsuario {
	
	public List<Usuario> consultarUsuarios(String contraseña);
	
	public List<Usuario> getUsuario();
	
	public void insertarUsuario(int id, String contraseña, String nombre, TipoRol rol, String area);
	
	public void updatePerfil(int id, TipoRol tipoRol);

}
