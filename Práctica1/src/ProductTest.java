import static org.junit.Assert.*;

import org.junit.Test;

public class ProductTest {

	@Test
	public void test() {
	User persona=new User("Pedro", "pedro@test.es", "pedro123");
	assertEquals(persona.getEmail(),"pedro@test.es");
	
	}

}
