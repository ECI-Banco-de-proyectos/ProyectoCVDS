package edu.eci.cvds.samples.persistencia.mybatisimpl;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.AreaIniciativaMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.samples.entities.AreaIniciativa;
import edu.eci.cvds.samples.entities.TipoArea;
import edu.eci.cvds.samples.persistencia.DAOAreaIniciativa;
import edu.eci.cvds.servicios.IniciativasFactory;

import java.util.List;

import com.google.inject.Inject;

public class MyBatisDAOAreaIniciativa implements DAOAreaIniciativa {

    //AreaIniciativaMapper areaIniciativaMapper = IniciativasFactory.instancia().areaIniciativaPersistencia();

    @Inject
    AreaIniciativaMapper areaIniciativaMapper;
    
    @Override
    public void insertAreaIniciativa(int id, TipoArea areaIni) {
        areaIniciativaMapper.insertAreaIniciativa(id, areaIni);
        //IniciativasFactory.instancia().session.commit();
    }

    @Override
    public List<AreaIniciativa> selectAreaIniciativa() {
        return areaIniciativaMapper.selectAreaIniciativa();
    }

}
