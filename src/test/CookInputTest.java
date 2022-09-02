package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import outils.CookInput;
import outils.Ingredient;
import outils.Plat;

class CookInputTest {
	
	static Plat pizza;
	static ArrayList<Ingredient> ingredients = new ArrayList<>();

	@BeforeAll
	static void initialize() {
		// Ajout des ingrédients
		ingredients.add(Ingredient.PATE_A_PIZZA);
		ingredients.add(Ingredient.SAUCE_TOMATE);
		ingredients.add(Ingredient.JAMBON);
		pizza = new Plat("Pizza", 0, ingredients);
		pizza.setIngredients(ingredients);
	}
	
	@Test
	void test() {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < ingredients.size(); i++) {
			res.append(ingredients.get(i).getShortcut());
		}
		
		assertFalse(CookInput.isCorrect(pizza, ""));
		assertFalse(CookInput.isCorrect(pizza, "a"));
		assertTrue(CookInput.isCorrect(pizza, res.toString()));
	}
	
	@Test
	void testNull() {
		assertFalse(CookInput.isCorrect(pizza, null));
		assertFalse(CookInput.isCorrect(null, ""));
		assertFalse(CookInput.isCorrect(null, null));
	}

}
