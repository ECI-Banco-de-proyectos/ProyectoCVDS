package pruebas;




import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;
import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.IniciativasAgrupadas;
import edu.eci.cvds.samples.entities.TipoArea;
import edu.eci.cvds.samples.entities.TipoRol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.impl.ServiciosIniciativasImpl;
import org.junit.Test;


public class Pruebas {
	ServiciosIniciativasImpl prueba = (ServiciosIniciativasImpl) IniciativasFactory.instancia().serviciosIniciativas();
	@Before
	public void Preparacion () {
		prueba.insertarUsuario("1234", "Usuario 1", TipoRol.Administrador, TipoArea.SecretariaGeneral.toString());
		int id=prueba.consultarIdPorNombreyContraseña("Usuario 1", "1234");
		prueba.insertarIniciativa(99, id, "Iniciativa de prueba", EstadoIniciativa.En_Revision, 0, Date.valueOf(LocalDate.now()), "Iniciativa de prueba.");
		
		
	}
	
	@Test
	public void DeberiaAutenticaUsuarios() {
		
		Usuario a=prueba.consultarUsuario("Usuario 1", "1234");
		
		Assert.assertEquals(a.getNombre()+" "+a.getContraseña(), "Usuario 1"+" "+"1234");
		
	}
	
	@Test
	public void DeberiaAsignarPerfil() {
		
		Usuario a=prueba.consultarUsuario("Usuario 1", "1234");
		int id=prueba.consultarIdPorNombreyContraseña("Usuario 1", "1234");
		prueba.actualizarPerfil(id, TipoRol.PMO_ODI);
		a=prueba.consultarUsuario("Usuario 1", "1234");
		Assert.assertEquals(TipoRol.PMO_ODI,a.getRol());
		
	}
	
	@Test
	public void DeberiaRegistrarUnaIdea() {
		
		
		Iniciativa b=prueba.consultarIniciativaId(99);
		
		Assert.assertEquals(b.descripcion,"Iniciativa de prueba.");
		
		
		
	}
	
	@Test
	public void DeberiaModificarEstadoIniciativa() {
		
		prueba.actualizarIniciativa(EstadoIniciativa.Solucionado, 99);
		Iniciativa b=prueba.consultarIniciativaId(99);
		Assert.assertEquals(EstadoIniciativa.Solucionado,b.getEstado());
		
	}
	
	
	
	@Test
	public void DeberiaConsultarPorPalabrasClave() {
		prueba.insertarPalabraClave("Iniciativa de prueba", 99);
		List<Iniciativa> ini=prueba.consultarIniciativasPalabraClave("Iniciativa de prueba");
		int id=ini.get(0).getId();
		
		
		Assert.assertEquals(id,99);
		
		prueba.elimiarPalabraClavePorId("Iniciativa de prueba");
		
	}
	
	@Test
	public void DeberiaAgrupar() {
		
		prueba.insertarPorIniciativasAgrupadas(99,"Empresas");
		List<IniciativasAgrupadas> agrupadas=prueba.consultarIniciativasAgrupadas();
		int id=agrupadas.get(agrupadas.size()-1).getIniciativaAgrupada();
		Assert.assertEquals(id,99);
		
	}
	
	
	
	
	
	@After
	public void Borrar () {
		prueba.borrarIniciativa(99);
		prueba.borrarUsuario("Usuario 1", "1234");
		
	}
	
}
