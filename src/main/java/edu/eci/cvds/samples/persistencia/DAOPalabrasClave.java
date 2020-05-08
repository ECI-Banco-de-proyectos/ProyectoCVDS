package edu.eci.cvds.samples.persistencia;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.PalabrasClave;

public interface DAOPalabrasClave {
	
	public List<PalabrasClave> consultaPalabrasClave();
	
	public PalabrasClave consultaPalabraClavePorId(String palabra);
	
	public List<PalabrasClave> consultarPalabraClavePorIniciativa(int idIniciativa);
	
	public void elimiarPalabraClavePorId(String palabra);
	
	public void insertarPalabraClave(String palabra, int iniciativa);


}
