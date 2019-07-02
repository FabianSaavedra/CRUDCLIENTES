package PruebaRESTFul;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EliminarTest.class, InsertarTest.class, ListarUnoTest.class, LstarTodoTest.class, ModificarTest.class })
public class AllTests {

}
