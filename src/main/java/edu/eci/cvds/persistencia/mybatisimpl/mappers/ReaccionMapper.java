package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

public interface ReaccionMapper {

	public void insertReaccion(@Param ("id_iniciativa") int idIni ,@Param ("nombre") String nombreUsu,@Param ("comentario") String comentario, @Param ("fecha") Date fecha);
	
	public void updateIniciativa(@Param("id_iniciativa") int idIni, @Param("voto") int votoIni);
}