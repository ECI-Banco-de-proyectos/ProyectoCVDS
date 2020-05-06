package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Area;

public interface AreaMapper {
	
	public List<Area> consultarAreas();
	
	public Area consultaAreaPorId(@Param("nombre") String id);

}
