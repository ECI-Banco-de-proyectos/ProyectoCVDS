package edu.eci.cvds.samples.persistencia.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.AreaMapper;
import edu.eci.cvds.samples.entities.Area;
import edu.eci.cvds.samples.persistencia.DAOArea;

public class MyBatisDAOArea implements DAOArea{

	@Inject
	AreaMapper areaMapper;
	
	@Override
	public List<Area> consultarAreas() {
		return areaMapper.consultarAreas();
	}

	@Override
	public Area consultaAreaPorId(String id) {
		return areaMapper.consultaAreaPorId(id);
	}
	

}
