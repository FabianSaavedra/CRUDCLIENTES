package PruebaRESTFul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import PruebaRESTFul.Model.Clientes;
import PruebaRESTFul.Model.Repository.ClientesRepositorio;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ListarUnoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private ClientesRepositorio dao;

	@Before
	public void setUp() throws Exception {
		Clientes clien=new Clientes("17603415-7","fabian","saavedra","fsaavedracam@gmail.com","40595959");
		this.entityManager.persist(clien);
		clien=new Clientes("17603415-8","Andrs","Campos","Acampos@gmail.com","40595958");
		this.entityManager.persist(clien);
	}

	//cuandoSituaciónEntoncesResultadoEsperado().
	@Test
	public void cuandoListoUnIdConocidaEntoncesTrue() {
		Clientes clien= this.dao.findById("17603415-7").get();
		boolean respuesta=clien.equals(new Clientes("17603415-7","fabian","saavedra","fsaavedracam@gmail.com","40595959"));
		assertTrue(respuesta);
	}

	@Test
	public void cuandoListoUnQueNoExisteEntonceFalse() {
		Clientes clien=this.dao.findById("147").orElse(null);
		boolean respuesta= !(clien==null);
		assertFalse("Cuando listp uno no existente es false y es "+respuesta,respuesta);
	}
	
	
}
