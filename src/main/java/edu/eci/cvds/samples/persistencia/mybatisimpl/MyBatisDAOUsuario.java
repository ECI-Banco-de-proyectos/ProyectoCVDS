package edu.eci.cvds.samples.persistencia.mybatisimpl;

import java.util.List;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistencia.DAOUsuario;
import edu.eci.cvds.servicios.IniciativasFactory;

public class MyBatisDAOUsuario implements DAOUsuario{

	UsuarioMapper usuarioMapper = IniciativasFactory.instancia().usuarioPersistencia();
	
	@Override
	public List<Usuario> consultarUsuarios(String contraseña) {
		return usuarioMapper.consultaUsuarios(contraseña);
	}

	@Override
	public void insertarUsuario(int id, String contraseña, String nombre, TipoRol rol) {
		usuarioMapper.insertarUsuario(id, contraseña, nombre, rol);
		IniciativasFactory.instancia().session.commit();
	}

	@Override
	public List<Usuario> getUsuario() {
		return usuarioMapper.getUsuarios();
	}

	@Override
	public void updatePerfil(int id, TipoRol tipoRol) {
		usuarioMapper.updatePerfil(id,tipoRol);
		IniciativasFactory.instancia().session.commit();
		
	}
	
	

}
