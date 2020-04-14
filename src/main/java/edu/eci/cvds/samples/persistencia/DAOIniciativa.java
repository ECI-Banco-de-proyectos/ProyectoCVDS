package edu.eci.cvds.samples.persistencia;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;

public interface DAOIniciativa {

	public void insertIniciativa(int id, int usuario, String nombre, EstadoIniciativa estado, int votos, Date fecha, String descripcion);
	
	public List<Iniciativa> selectIniciativa();
}
