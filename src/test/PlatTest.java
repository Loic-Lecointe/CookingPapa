package test;
import outils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlatTest {
	MealOrder plat;

	@BeforeEach
	void Initialization() {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		ingredients.toArray(Ingredient.values());
		
		Recipe platReceipe = new Recipe("p", ingredients, false);
		
		plat = new MealOrder(platReceipe);
	}
	
	@Test
	void testGetter() {
		assertEquals("p",plat.getName());
		assertTrue(plat.getIngredients().size() == 0);
	}
}
