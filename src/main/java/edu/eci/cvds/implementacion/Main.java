package edu.eci.cvds.implementacion;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import edu.eci.cvds.samples.entities.Iniciativa;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistencia.DAOUsuario;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;

public class Main {

	public static void main(String[] args) {
		ServiciosIniciativas ser = IniciativasFactory.instancia().serviciosIniciativas();
		List<Iniciativa> l= ser.ordenandoIniciativas("estado");
		for(Iniciativa i:l ){
			System.out.println(i.getEstado());
		}
		
		/*
		InputStream inputStream;
		try {
			//Se modifico el build del pom para agregar el resource
			String resource = "mybatis_config.xml";
			InputStream reader = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
			usuarioMapper.insertarUsuario(2, "123", "German", TipoRol.proponenteIniciativa);
			session.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		*/
		

	}

}
