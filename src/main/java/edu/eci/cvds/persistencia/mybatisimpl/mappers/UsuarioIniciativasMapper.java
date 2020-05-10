package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.UsuarioIniciativas;

public interface UsuarioIniciativasMapper {
	
	public List<UsuarioIniciativas> selectUsuarioIniciativas();
	
	public void insertarUsuarioIniciativa(@Param("usuario") int usuario, @Param("iniciativa") int iniciativa, @Param("numerovotos") int numeroVotos);
	
	public void updateNumeroVotos(@Param("usuario") int usuario, @Param("iniciativa") int iniciativa, @Param("numerovotos") int numeroVotos);
	
	public void deleteUsuarioIniciativa(@Param("usuario") int usuario, @Param("iniciativa") int iniciativa);

}
