package edu.eci.cvds.samples.persistencia.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioIniciativasMapper;
import edu.eci.cvds.samples.entities.UsuarioIniciativas;
import edu.eci.cvds.samples.persistencia.DAOUsuarioIniciativas;

public class MyBatisDAOUsuarioIniciativas implements DAOUsuarioIniciativas{

	@Inject
	UsuarioIniciativasMapper usuarioIniciativasMapper;
	
	@Override
	public List<UsuarioIniciativas> selectUsuarioIniciativas() {
		return usuarioIniciativasMapper.selectUsuarioIniciativas();
	}

	@Override
	public void insertarUsuarioIniciativa(int usuario, int iniciativa, int numeroVotos) {
		usuarioIniciativasMapper.insertarUsuarioIniciativa(usuario, iniciativa, numeroVotos);
		
	}

	@Override
	public void updateNumeroVotos(int usuario, int iniciativa, int numeroVotos) {
		usuarioIniciativasMapper.updateNumeroVotos(usuario, iniciativa, numeroVotos);
		
	}

	@Override
	public void deleteUsuarioIniciativa(int usuario, int iniciativa) {
		usuarioIniciativasMapper.deleteUsuarioIniciativa(usuario, iniciativa);
		
	}

}
