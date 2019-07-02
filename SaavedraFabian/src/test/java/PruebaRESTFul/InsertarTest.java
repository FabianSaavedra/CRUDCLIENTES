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
public class InsertarTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private ClientesRepositorio dao;
	
	@Before
	public void setUp() throws Exception {
		Clientes clien=new Clientes("17603415-7","fabian","saavedra","fsaavedracam@gmail.com","40595959");
		this.entityManager.persist(clien);
	}

	// cuandoSituaciónEntoncesResultadoEsperado().
	@Test
	public void cuandoInsertoUnoQueNoExisteEntonces2() {
		this.dao.save(new Clientes("17603415-8","Andrs","Campos","Acampos@gmail.com","40595958"));
		int largo=this.dao.findAll().size();
		assertTrue("Cuando inserto un nuevo largo es 2 y es "+largo,largo==2);
	}

	/*
	@Test
	public void cuandoInsertoUnIdExistenteEntonces1() {
		
		this.dao.save(new Clientes("17603415-7","Andrs","Campos","Acampos@gmail.com","40595958"));
		int largo=this.dao.findAll().size();
		assertTrue("Cuando inserto uno con id que existe largo es 1 y es "+largo,largo==1);
	}
	*/

	
	@Test
	public void cuandoInsetoUnoIdVasioEntoncesUno() {
		this.dao.save(new Clientes("","Andrs","Campos","Acampos@gmail.com","40595958"));
		int largo=this.dao.findAll().size();
		System.out.println(this.dao.findAll());
		assertTrue("Cuando inserto un nuevo largo es 2 y es "+largo,largo==2);
	}
	
}
