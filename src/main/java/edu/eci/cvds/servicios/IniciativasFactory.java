package edu.eci.cvds.servicios;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.samples.persistencia.DAOIniciativa;
import edu.eci.cvds.samples.persistencia.DAOUsuario;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOIniciativa;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOUsuario;
import edu.eci.cvds.samples.services.impl.ServiciosIniciativasImpl;

public class IniciativasFactory extends AbstractModule{

	public SqlSession session;
	
	public static IniciativasFactory iniciativaFactory = new IniciativasFactory();
	
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
		
		
		
	}
	
	public DAOUsuario usuarioImplementado() {
		Injector injector = Guice.createInjector(new IniciativasFactory());
		return injector.getInstance(DAOUsuario.class);
	}
	
	public DAOIniciativa iniciativaImplementado() {
		Injector injector = Guice.createInjector(new IniciativasFactory());
		return injector.getInstance(DAOIniciativa.class);
	}
	
	public ServiciosIniciativas serviciosIniciativas() {
		Injector injector = Guice.createInjector(new IniciativasFactory());
		return injector.getInstance(ServiciosIniciativas.class);
	}
	
	public UsuarioMapper usuarioPersistencia() {
		cargarSesion();
		return session.getMapper(UsuarioMapper.class);
	}
	
	public IniciativaMapper iniciativaPersistencia() {
		cargarSesion();
		return session.getMapper(IniciativaMapper.class);
	}
	
	public static IniciativasFactory instancia() {
		return iniciativaFactory;
	}
	
	

}
