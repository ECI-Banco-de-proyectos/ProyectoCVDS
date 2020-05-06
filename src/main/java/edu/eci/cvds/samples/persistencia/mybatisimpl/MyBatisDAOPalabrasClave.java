package edu.eci.cvds.samples.persistencia.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.PalabrasClaveMapper;
import edu.eci.cvds.samples.entities.PalabrasClave;
import edu.eci.cvds.samples.persistencia.DAOPalabrasClave;

public class MyBatisDAOPalabrasClave implements DAOPalabrasClave{
	
	@Inject
	PalabrasClaveMapper palabrasClaveMapper;

	@Override
	public List<PalabrasClave> consultaPalabrasClave() {
		return palabrasClaveMapper.consultaPalabrasClave();
	}

	@Override
	public PalabrasClave consultaPalabraClavePorId(String palabra) {
		return palabrasClaveMapper.consultaPalabraClavePorId(palabra);
	}

	@Override
	public void elimiarPalabraClavePorId(String palabra) {
		palabrasClaveMapper.elimiarPalabraClavePorId(palabra);
		
	}

	@Override
	public void insertarPalabraClave(String palabra, int iniciativa) {
		palabrasClaveMapper.insertarPalabraClave(palabra, iniciativa);
		
	}
	
	

}
