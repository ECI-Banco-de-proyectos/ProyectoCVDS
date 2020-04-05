package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;


public interface UsuarioMapper {
	
	public List<Usuario> consultaUsuarios(@Param("id") String id);
	
	public void insertarUsuario(@Param("id") int id,@Param("cont") String contraseña,@Param("name") String nombre,@Param("rol") TipoRol tipoRol);
	
}
