package edu.eci.cvds.servicios;

import static com.google.inject.Guice.createInjector;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;

import edu.eci.cvds.samples.persistencia.DAOArea;
import edu.eci.cvds.samples.persistencia.DAOAreaIniciativa;
import edu.eci.cvds.samples.persistencia.DAOIniciativa;
import edu.eci.cvds.samples.persistencia.DAOIniciativasAgrupadas;
import edu.eci.cvds.samples.persistencia.DAOPalabrasClave;
import edu.eci.cvds.samples.persistencia.DAOReaccion;
import edu.eci.cvds.samples.persistencia.DAOUsuario;
import edu.eci.cvds.samples.persistencia.DAOUsuarioIniciativas;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOArea;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOAreaIniciativa;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOIniciativa;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOIniciativasAgrupadas;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOPalabrasClave;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOReaccion;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOUsuario;
import edu.eci.cvds.samples.persistencia.mybatisimpl.MyBatisDAOUsuarioIniciativas;
import edu.eci.cvds.samples.services.impl.ServiciosIniciativasImpl;

public class IniciativasFactory{

	
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
				bind(DAOUsuarioIniciativas.class).to(MyBatisDAOUsuarioIniciativas.class);

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
	
	public DAOUsuarioIniciativas usuarioIniciativasImplementado() {
		return injector.getInstance(DAOUsuarioIniciativas.class);
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
