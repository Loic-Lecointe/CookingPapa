package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import outils.Ingredient;

class IngredientTest {

	@Test
	void testGetShortcut() {
		assertEquals('d',Ingredient.SAUCISSE_DE_TOULOUSE.getShortcut());
		assertEquals('c',Ingredient.CREVETTE.getShortcut());
		assertEquals('h',Ingredient.THON.getShortcut());
		assertEquals('z',Ingredient.CHORIZO.getShortcut());
		assertEquals('v',Ingredient.VIANDE_A_KEBAB.getShortcut());
		assertEquals('p',Ingredient.PATE_A_PIZZA.getShortcut());
	}
	
	@Test
	void testGetName() {
		assertEquals("saucisse de toulouse",Ingredient.SAUCISSE_DE_TOULOUSE.getName());
		assertEquals("tomate",Ingredient.TOMATE.getName());
		assertEquals("echalotte",Ingredient.ECHALOTTE.getName());
		assertEquals("pain",Ingredient.PAIN.getName());
		assertEquals("biere",Ingredient.BIERE.getName());
		assertEquals("tortilla",Ingredient.TORTILLA.getName());
	}

}
