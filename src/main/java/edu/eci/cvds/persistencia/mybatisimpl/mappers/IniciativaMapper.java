package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;

public interface IniciativaMapper {
	
	public void insertIniciativa(@Param("id") int id,@Param("user") int user,@Param("name") String name,@Param("est") EstadoIniciativa estado,@Param("vot") int votos,@Param("fec") Date fecha,@Param("desc") String descripcion);

	public void cambiarIniciativa(@Param("estado") EstadoIniciativa estado, @Param("id") int id);

	public void cambiarIniciativas(@Param("name") String name, @Param("descrip") String descrip, @Param("id") int id);

	public void claveIniciativas(@Param("clave")String clave);

	public List<Iniciativa> selectIniciativas();

	public List<Iniciativa> ordenDeIniciativa (@Param("columnaSeleccionada") String columna);
	
	public List<HashMap> selectIniciativaPorEstado();
	
	public Iniciativa consultarIniciativaId(@Param("id") int id);
	
	public void borrarIniciativa(@Param("id") int id);
}
