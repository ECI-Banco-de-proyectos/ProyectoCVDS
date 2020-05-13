package edu.eci.cvds.samples.persistencia;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Reaccion;

public interface DAOReaccion {

	public void insertReaccion( int idIni, String nombreUsu, String comentario,  Date fecha);
	
	public void updateIniciativa( int idIni,  int votoIni);

	public List<Reaccion> selectReacciones();

}
