package outils;
import outils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlatTest {
	Plat plat;
	
	
	@BeforeEach
	void Initialization() {
		plat = new Plat("p",1);
		
	}
	
	@Test
	void testGetter() {
		assertEquals("p",plat.getName());
		assertEquals(1,plat.getPoints());
		assertTrue(plat.getIngredients().size() == 0);
		
		
	}
}
