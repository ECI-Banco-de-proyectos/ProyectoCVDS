package edu.eci.cvds.samples.persistencia;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Area;

public interface DAOArea {
	
	public List<Area> consultarAreas();
	
	public Area consultaAreaPorId(String id);

}
