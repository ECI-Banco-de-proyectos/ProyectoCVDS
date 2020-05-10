package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.PalabrasClave;

public interface PalabrasClaveMapper {

	public List<PalabrasClave> consultaPalabrasClave();
	
	public PalabrasClave consultaPalabraClavePorId(@Param("palabraClave") String palabra);
	
	public List<PalabrasClave> consultarPalabraClavePorIniciativa(@Param("idIniciativa") int idIniciativa);
	
	public void elimiarPalabraClavePorId(@Param("palabraClave") String palabra);
	
	public void insertarPalabraClave(@Param("palabra") String palabra, @Param("iniciativa") int iniciativa);
	 
}
