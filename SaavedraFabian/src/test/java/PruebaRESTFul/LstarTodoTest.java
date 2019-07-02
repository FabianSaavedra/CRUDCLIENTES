package PruebaRESTFul;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
public class LstarTodoTest {

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
		clien=new Clientes("17603415-9","Israel","Lopez","lopez@gmail.com","40518936");
		this.entityManager.persist(clien);
		
		
	}

	//cuandoSituaciónEntoncesResultadoEsperado
	@Test
	public void cuandoListoTodoEntonces3() {
		int largo= this.dao.findAll().size();
		assertTrue("Cuando retorno todo es 3 y es "+largo,largo==3);
	}

	@Test
	public void cuandoListoUnListaVaciaEntoncesTrue() {
		this.dao.deleteAll();
		int largo= this.dao.findAll().size();
		assertTrue("Cuando retorno una lista vacia todo es 0 y es "+largo,largo==0);
	}
	
	@Test
	public void cuandoListoUnaListaDeUnElementoEntonces1() {
		this.dao.deleteById("17603415-7");
		this.dao.deleteById("17603415-8");
		ArrayList<Clientes> arr=(ArrayList<Clientes>) this.dao.findAll();
		int largo= this.dao.findAll().size();
		boolean esArrayList=false;
		if(arr instanceof ArrayList) {
			esArrayList=true;
		}
		assertTrue("Cuando retorno una lista con un elemento todo es 01y es "+largo,largo==1 &&esArrayList);
		
	}
}
