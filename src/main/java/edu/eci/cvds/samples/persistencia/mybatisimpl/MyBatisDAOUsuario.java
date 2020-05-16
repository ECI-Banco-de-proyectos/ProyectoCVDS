package edu.eci.cvds.samples.persistencia.mybatisimpl;

import java.util.List;
import com.google.inject.Inject;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistencia.DAOUsuario;

public class MyBatisDAOUsuario implements DAOUsuario{

	//UsuarioMapper usuarioMapper = IniciativasFactory.instancia().usuarioPersistencia();
	@Inject
	UsuarioMapper usuarioMapper;
	
	@Override
	public List<Usuario> consultarUsuarios(String contraseña) {
		return usuarioMapper.consultaUsuarios(contraseña);
	}

	@Override
	public void insertarUsuario(int id, String contraseña, String nombre, TipoRol rol, String area) {
		usuarioMapper.insertarUsuario(id, contraseña, nombre, rol, area);
		//IniciativasFactory.instancia().session.commit();
	}

	@Override
	public List<Usuario> getUsuario() {
		return usuarioMapper.getUsuarios();
	}

	@Override
	public void updatePerfil(int id, TipoRol tipoRol) {
		usuarioMapper.updatePerfil(id,tipoRol);
		//IniciativasFactory.instancia().session.commit();
	}

	@Override
	public int consultarIdPorNombreyContraseña(String nombre, String contraseña) {
		return usuarioMapper.consultarIdPorNombreyContraseña(nombre, contraseña);
	}

	@Override
	public List<Usuario> consultarUsuarioPorNombreyContraseña(String nombre, String contraseña) {
		return usuarioMapper.consultarUsuarioPorNombreyContraseña(nombre, contraseña);
	}

	@Override
	public void borrarUsuario(String nombre, String contrasena) {
		usuarioMapper.borrarUsuario(nombre, contrasena);
		
	}
	
	

}
