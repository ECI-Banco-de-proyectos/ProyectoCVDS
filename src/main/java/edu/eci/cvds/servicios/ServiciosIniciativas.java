package edu.eci.cvds.servicios;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Area;
import edu.eci.cvds.samples.entities.AreaIniciativa;
import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.IniciativasAgrupadas;
import edu.eci.cvds.samples.entities.PalabrasClave;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.UsuarioIniciativas;
import edu.eci.cvds.samples.managedbeans.ReaccionBean;
import edu.eci.cvds.samples.persistencia.DAOIniciativa;

public interface ServiciosIniciativas {

	public DAOIniciativa buscarIniciativas(String clave);
	
	public int consultarIdPorNombreyContraseña(String nombre, String contraseña);

	public List<Usuario> consultarUsuariosPorContraseña(String contraseña);
	
	public Usuario consultarUsuarioPorId(int id); 
	
	public List<Usuario> consultarUsuarios();
	
	public List<Usuario> consultarUsuarioPorNombreyContraseña(String nombre, String contraseña);
	
	public Usuario consultarUsuario(String nombre, String contraseña);
	
	public void insertarUsuario(String contraseña, String nombre, TipoRol rol, String area);
	
	public void actualizarPerfil(int id, TipoRol tipoRol);

	public void actualizarIniciativa(EstadoIniciativa estado, int id);
	
	public void insertarIniciativa(int id, int usuario, String nombre, EstadoIniciativa estado, int votos, Date fecha, String descripcion);
	
	public List<Iniciativa> consultarIniciativas();
	
	public List<Iniciativa> consultarIniciativasPalabraClave(String word);

	public List<Iniciativa> ordenandoIniciativas(String columnaSeleccionada);

	public ReaccionBean insertarReacciones (int idIni, String nombre, String comentario, Date fecha);
	
	public void actualizarIniciativasVotos (int id, int voto);

	public List<AreaIniciativa> selectAreaIniciativa();

	public List<PalabrasClave> consultaPalabrasClave();
	
	public PalabrasClave consultaPalabraClavePorId(String palabra);
	
	public List<PalabrasClave> consultarPalabraClavePorIniciativa(int idIniciativa);
	
	public void insertarPalabraClave(String palabra, int iniciativa);
	
	public void elimiarPalabraClavePorId(String palabra);
	
	public List<Area> consultarAreas();
	
	public Area consultaAreaPorId(String id);

	public void insertarPorIniciativasAgrupadas(int id, String name);

	public List<IniciativasAgrupadas> consultarIniciativasAgrupadas();
	
	public List<UsuarioIniciativas> selectUsuarioIniciativas();
	
	public void insertarUsuarioIniciativa(int usuario, int iniciativa, int numeroVotos);
	
	public void updateNumeroVotos(int usuario, int iniciativa, int numeroVotos);

	public void deleteUsuarioIniciativa(int usuario, int iniciativa);
	
	public int numeroVotosPorIniciativa(int idIniciativa);
	
	public void borrarUsuario(String nombre, String contrasena);
	
	public Iniciativa consultarIniciativaId( int id);
	
	public void borrarIniciativa( int id);
	
}
