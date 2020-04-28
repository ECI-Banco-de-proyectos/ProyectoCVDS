package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.AreaIniciativa;
import edu.eci.cvds.samples.entities.TipoArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaIniciativaMapper {
    public void insertAreaIniciativa(@Param("id") int id, @Param("areaIni") TipoArea areaIni);

    public List<AreaIniciativa> selectAreaIniciativa();

}
