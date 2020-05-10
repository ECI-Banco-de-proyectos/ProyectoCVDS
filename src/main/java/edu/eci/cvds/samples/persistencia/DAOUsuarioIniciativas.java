package edu.eci.cvds.samples.persistencia;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.UsuarioIniciativas;

public interface DAOUsuarioIniciativas {

	public List<UsuarioIniciativas> selectUsuarioIniciativas();
	
	public void insertarUsuarioIniciativa(int usuario, int iniciativa, int numeroVotos);
	
	public void updateNumeroVotos(int usuario, int iniciativa, int numeroVotos);
	
	public void deleteUsuarioIniciativa(int usuario, int iniciativa);

}
