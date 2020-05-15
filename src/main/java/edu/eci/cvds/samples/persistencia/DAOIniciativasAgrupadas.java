package edu.eci.cvds.samples.persistencia;

import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.IniciativasAgrupadas;

import java.util.List;

public interface DAOIniciativasAgrupadas {
    public void insertarInicitivasAgrupadas(int id, String name);
    public List<IniciativasAgrupadas> selectIniciativaAgrupada();
    public void cambiarAgrupados(String newname, String oldname);

}
