package test;
import outils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlatTest {
	Order plat;

	@BeforeEach
	void Initialization() {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		ingredients.toArray(Ingredient.values());
		
		Receipe platReceipe = new Receipe("p", ingredients, false);
		
		plat = new Order(platReceipe);
	}
	
	@Test
	void testGetter() {
		assertEquals("p",plat.getName());
		assertEquals(1,plat.getPoints());
		assertTrue(plat.getIngredients().size() == 0);
	}
}
