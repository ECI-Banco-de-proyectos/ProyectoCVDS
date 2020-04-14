package edu.eci.cvds.samples.persistencia.mybatisimpl;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.persistencia.DAOIniciativa;
import edu.eci.cvds.servicios.IniciativasFactory;

public class MyBatisDAOIniciativa implements DAOIniciativa{
	
	IniciativaMapper iniciativaMapper = IniciativasFactory.instancia().iniciativaPersistencia();

	@Override
	public void insertIniciativa(int id, int usuario, String nombre, EstadoIniciativa estado, int votos, Date fecha,
			String descripcion) {
		iniciativaMapper.insertIniciativa(id, usuario, nombre, estado, votos, fecha, descripcion);
		IniciativasFactory.instancia().session.commit();
	}

	@Override
	public List<Iniciativa> selectIniciativa() {
		return iniciativaMapper.selectIniciativas();
	}

}
