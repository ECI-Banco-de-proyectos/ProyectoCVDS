package edu.eci.cvds.samples.persistencia;

import java.util.List;

import edu.eci.cvds.samples.entities.PalabrasClave;

public interface DAOPalabrasClave {
	
	public List<PalabrasClave> consultaPalabrasClave();
	
	public PalabrasClave consultaPalabraClavePorId(String palabra);
	
	public void elimiarPalabraClavePorId(String palabra);
	
	public void insertarPalabraClave(String palabra, int iniciativa);


}
