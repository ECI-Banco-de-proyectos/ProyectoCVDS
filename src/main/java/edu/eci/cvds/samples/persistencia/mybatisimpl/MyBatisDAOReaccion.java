package edu.eci.cvds.samples.persistencia.mybatisimpl;

import java.sql.Date;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.ReaccionMapper;
import edu.eci.cvds.samples.persistencia.DAOReaccion;
import edu.eci.cvds.servicios.IniciativasFactory;

public class MyBatisDAOReaccion implements DAOReaccion{
	
	ReaccionMapper reaccionMapper = IniciativasFactory.instancia().reaccionPersistencia();
	
	@Override
	public void insertReaccion(int id_i, String nombreUsuario,String comentario,Date fecha) {
		reaccionMapper.insertReaccion(id_i,nombreUsuario, comentario,fecha);
		IniciativasFactory.instancia().session.commit();
	}

	@Override
	public void updateIniciativa(int idIni, int votoIni) {
		reaccionMapper.updateIniciativa(idIni,votoIni);
		IniciativasFactory.instancia().session.commit();
		
	}
	
}
