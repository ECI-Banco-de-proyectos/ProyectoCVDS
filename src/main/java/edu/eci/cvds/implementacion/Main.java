package edu.eci.cvds.implementacion;

/**
import com.google.inject.Inject;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.eci.cvds.samples.entities.*;

import edu.eci.cvds.samples.entities.Iniciativa;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.samples.persistencia.DAOUsuario;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;
*/
public class Main {


	public static void main(String[] args) {
		/*

		public TipoArea areaConocimiento;

	public static boolean buscar(int ini){
		List<AreaIniciativa> ser = IniciativasFactory.instancia().areaIniciativaPersistencia().selectAreaIniciativa();
		for(AreaIniciativa i: ser){
			if(i.getIdIniciativa()==ini && i.getAreaConocimiento().equals(TipoArea.Sistemas)){
				return true;
			}
		}
		return false;
	}
		ArrayList<TipoArea> areas;
		List<Iniciativa> lista;

		lista = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();

		for(Iniciativa ini:lista){
			int temp=ini.getId();
			if(buscar(temp)){
				System.out.println(ini.getNombre());
			}
		}


		List<AreaIniciativa> ser = IniciativasFactory.instancia().areaIniciativaPersistencia().selectAreaIniciativa();
		for(AreaIniciativa i:ser ){
			System.out.println(i.getAreaConocimiento());
			if(i.getAreaConocimiento().equals(TipoArea.Matematicas)){
				System.out.println(":)");
			}
		}

		List<AreaIniciativa> ser = IniciativasFactory.instancia().areaIniciativaPersistencia().selectAreaIniciativa();
		for(AreaIniciativa i:ser ){
			System.out.println(i.getAreaConocimiento());
		}

		ServiciosIniciativas ser = IniciativasFactory.instancia().serviciosIniciativas();
		ser.insertarReacciones(1, "german", "Me gusta",Date.valueOf(LocalDate.now()));

=======
		
		ServiciosIniciativas ser = IniciativasFactory.instancia().serviciosIniciativas();
		ser.insertarReacciones(1, "german", "Me gusta",Date.valueOf(LocalDate.now()));
		/*
>>>>>>> German
		List<Iniciativa> l= ser.ordenandoIniciativas("estado");
		for(Iniciativa i:l ){
			System.out.println(i.getEstado());
		}

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
			TODO Auto-generated catch block
			e.printStackTrace();
		} 
		*/
	}
}


