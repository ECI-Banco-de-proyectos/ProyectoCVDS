package edu.eci.cvds.samples.persistencia.mybatisimpl;

import java.sql.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.ReaccionMapper;
import edu.eci.cvds.samples.entities.Reaccion;
import edu.eci.cvds.samples.persistencia.DAOReaccion;

public class MyBatisDAOReaccion implements DAOReaccion{
	
	//ReaccionMapper reaccionMapper = IniciativasFactory.instancia().reaccionPersistencia();
	
	@Inject
	ReaccionMapper reaccionMapper;
	
	@Override
	public void insertReaccion(int id_i, String nombreUsuario,String comentario,Date fecha) {
		reaccionMapper.insertReaccion(id_i,nombreUsuario, comentario,fecha);
		//IniciativasFactory.instancia().session.commit();
	}

	@Override
	public void updateIniciativa(int idIni, int votoIni) {
		reaccionMapper.updateIniciativa(idIni,votoIni);
		//IniciativasFactory.instancia().session.commit();
	}

	@Override
	public List<Reaccion> selectReacciones() {
		return reaccionMapper.selectReacciones();
	}

}
