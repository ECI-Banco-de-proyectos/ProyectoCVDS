package edu.eci.cvds.samples.persistencia;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

public interface DAOReaccion {

	public void insertReaccion( int idIni, String nombreUsu, String comentario,  Date fecha);
	
	public void updateIniciativa( int idIni,  int votoIni);

}
