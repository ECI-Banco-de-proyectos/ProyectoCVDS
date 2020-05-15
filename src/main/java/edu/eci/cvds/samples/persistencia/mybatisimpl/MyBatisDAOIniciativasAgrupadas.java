package edu.eci.cvds.samples.persistencia.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativasAgrupadasMapper;
import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.IniciativasAgrupadas;
import edu.eci.cvds.samples.persistencia.DAOIniciativasAgrupadas;
import edu.eci.cvds.samples.persistencia.DAOUsuario;

import java.sql.Date;
import java.util.List;

public class MyBatisDAOIniciativasAgrupadas  implements DAOIniciativasAgrupadas{

    @Inject
    IniciativasAgrupadasMapper AgruparIniciativaMapper;

    @Override
    public void insertarInicitivasAgrupadas(int id, String name ) {
        AgruparIniciativaMapper.insertIniciativaAgrupada(id, name);
        //IniciativasFactory.instancia().session.commit();
    }

    @Override
    public List<IniciativasAgrupadas> selectIniciativaAgrupada() {

        return AgruparIniciativaMapper.selectIniciativaAgrupada();
    }

    @Override
    public void cambiarAgrupados(String newname, String oldname) {
        AgruparIniciativaMapper.cambiarAgrupados(newname, oldname);
    }



}
