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
public class EliminarTest {
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private ClientesRepositorio dao;
	
	//public Clientes(String rut, String nombres, String apellidos, String email, String celular)
	
	@Before
	public void setUp() throws Exception {
		Clientes clien=new Clientes("17603415-7","fabian","saavedra","fsaavedracam@gmail.com","40595959");
		this.entityManager.persist(clien);
		clien=new Clientes("17603415-8","Andrs","Campos","Acampos@gmail.com","40595958");
		this.entityManager.persist(clien);
	}

	//cuandoSituaciónEntoncesResultadoEsperado()
	@Test
	public void cuandoEliminoUnoEntonces2() {
		this.dao.deleteById("17603415-7");
		int largo=this.dao.findAll().size();
		assertTrue("Cuando elimino uno el largo es 1 y es "+largo,largo==1);
	}

	@Test 
	public void cuandoEliminoTodoEntonces0() {
		this.dao.deleteAll();
		int largo=this.dao.findAll().size();
		assertTrue("Cuando elimino todo el largo es 0 y es "+largo,largo==0);
	}
	
	@Test
	public void cuandoEliminoUnoQueNoExiste() {
		
		int largoAntes=this.dao.findAll().size();
		try {
			this.dao.deleteById("12");
		}catch (Exception e) {
			int largoDespues=this.dao.findAll().size();
			assertTrue("Cuando elimino uno que no existe el largo es 2 y es "+largoAntes,largoAntes==largoDespues);
		}
	}
		
		
}
