package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.IniciativasAgrupadas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IniciativasAgrupadasMapper {

    public void insertIniciativaAgrupada(@Param("id") int id, @Param("name") String name);
    public List<IniciativasAgrupadas> selectIniciativaAgrupada();
    public void cambiarAgrupados(@Param("newname") String newname, @Param("oldname") String oldname);

}
