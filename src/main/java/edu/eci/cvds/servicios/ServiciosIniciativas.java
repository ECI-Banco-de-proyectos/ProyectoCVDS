package edu.eci.cvds.servicios;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosIniciativas {

	public List<Usuario> consultarUsuariosPorContraseña(String contraseña);
	
	public List<Usuario> consultarUsuarios();
	
	public void insertarUsuario(String contraseña, String nombre, TipoRol rol);
	
	public void actualizarPerfil(int id, TipoRol tipoRol);
	
	public void insertarIniciativa(int id, int usuario, String nombre, EstadoIniciativa estado, int votos, Date fecha, String descripcion);
	
	public List<Iniciativa> consultarIniciativas();
}
