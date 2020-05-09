package edu.eci.cvds.servicios;

import static com.google.inject.Guice.createInjector;

import java.io.IOException;
import java.io.InputStream;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.AreaIniciativaMapper;
import edu.eci.cvds.samples.persistencia.*;
import edu.eci.cvds.samples.persistencia.mybatisimpl.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.ReaccionMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.samples.services.impl.ServiciosIniciativasImpl;

public class IniciativasFactory{

	public SqlSession session;
	
	public static IniciativasFactory iniciativaFactory = new IniciativasFactory();
	private static Injector injector;
	
	public IniciativasFactory(){
		injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis_config.xml");
                bind(DAOUsuario.class).to(MyBatisDAOUsuario.class);
        		bind(ServiciosIniciativas.class).to(ServiciosIniciativasImpl.class);
        		bind(DAOIniciativa.class).to(MyBatisDAOIniciativa.class);
        		bind(DAOReaccion.class).to(MyBatisDAOReaccion.class);
        		bind(DAOAreaIniciativa.class).to(MyBatisDAOAreaIniciativa.class);
        		bind(DAOPalabrasClave.class).to(MyBatisDAOPalabrasClave.class);
        		bind(DAOArea.class).to(MyBatisDAOArea.class);
				bind(DAOIniciativasAgrupadas.class).to(MyBatisDAOIniciativasAgrupadas.class);

            }

        }
        );
	}
	
	/**
	public void cargarSesion() {
		String resource = "mybatis_config.xml";
		InputStream reader;
		try {
			reader = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			this.session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
	}
	

	@Override
	protected void configure() {
		bind(DAOUsuario.class).to(MyBatisDAOUsuario.class);
		bind(ServiciosIniciativas.class).to(ServiciosIniciativasImpl.class);
		bind(DAOIniciativa.class).to(MyBatisDAOIniciativa.class);
		bind(DAOReaccion.class).to(MyBatisDAOReaccion.class);
		bind(DAOAreaIniciativa.class).to(MyBatisDAOAreaIniciativa.class);
	}
	*/


	public DAOUsuario usuarioImplementado() {
		//Injector injector = Guice.createInjector(new IniciativasFactory());
		return injector.getInstance(DAOUsuario.class);
	}
	
	public DAOIniciativa iniciativaImplementado() {
		//Injector injector = Guice.createInjector(new IniciativasFactory());
		return injector.getInstance(DAOIniciativa.class);
	}
	
	public DAOReaccion reaccionImplementado() {
		//Injector injector = Guice.createInjector(new IniciativasFactory());
		return injector.getInstance(DAOReaccion.class);
	}

	public DAOAreaIniciativa areaIniciativaImplementado() {
		//Injector injector = Guice.createInjector(new IniciativasFactory());
		return injector.getInstance(DAOAreaIniciativa.class);
	}
	
	public DAOPalabrasClave palabrasClaveImplementado() {
		return injector.getInstance(DAOPalabrasClave.class);
	}
	
	public DAOArea areasImplementado() {
		return injector.getInstance(DAOArea.class);
	}
	
	public ServiciosIniciativas serviciosIniciativas() {
		//Injector injector = Guice.createInjector(new IniciativasFactory());
		return injector.getInstance(ServiciosIniciativas.class);
	}
	
	
	/**
	public UsuarioMapper usuarioPersistencia() {
		//cargarSesion();
		return session.getMapper(UsuarioMapper.class);
	}
	
	public IniciativaMapper iniciativaPersistencia() {
		cargarSesion();
		return session.getMapper(IniciativaMapper.class);
	}
	
	public ReaccionMapper reaccionPersistencia() {
		cargarSesion();
		return session.getMapper(ReaccionMapper.class);
	}

	public AreaIniciativaMapper areaIniciativaPersistencia() {
		cargarSesion();
		return session.getMapper(AreaIniciativaMapper.class);
	}
	*/
	public DAOIniciativasAgrupadas IniciativasAgrupadasImplementando() {
		return injector.getInstance(DAOIniciativasAgrupadas.class);
	}
	
	public static IniciativasFactory instancia() {
		return iniciativaFactory;
	}
	
	

}
