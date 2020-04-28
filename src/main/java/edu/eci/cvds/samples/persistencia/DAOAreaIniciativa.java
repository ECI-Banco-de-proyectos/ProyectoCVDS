package edu.eci.cvds.samples.persistencia;

import edu.eci.cvds.samples.entities.AreaIniciativa;
import edu.eci.cvds.samples.entities.TipoArea;
import java.util.List;

public interface DAOAreaIniciativa {

    public void insertAreaIniciativa(int id, TipoArea areaIni);

    public List<AreaIniciativa> selectAreaIniciativa();
}
