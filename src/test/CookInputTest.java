package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import outils.CookInput;
import outils.Ingredient;
import outils.Order;
import outils.Receipe;

class CookInputTest {
	
	static Order pizza;
	static ArrayList<Ingredient> ingredients = new ArrayList<>();

	@BeforeAll
	static void initialize() {
		// Ajout des ingrédients
		ingredients.add(Ingredient.PATE_A_PIZZA);
		ingredients.add(Ingredient.SAUCE_TOMATE);
		ingredients.add(Ingredient.JAMBON);
		
		Receipe pizzaReceipe = new Receipe("Pizza", ingredients);
		
		pizza = new Order(pizzaReceipe);
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
