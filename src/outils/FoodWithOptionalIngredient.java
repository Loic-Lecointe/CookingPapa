package outils;

import java.util.ArrayList;
import java.util.List;

import outils.Ingredient;
import outils.Plat;

public class FoodWithOptionalIngredient extends Plat implements OptionalIngredient {
	private List<Ingredient> optionalIngredient;

	public FoodWithOptionalIngredient(String name, int points, ArrayList<Ingredient> ingredients, ArrayList<Ingredient> optionalIngredient) {
		super(name, points, ingredients);
		this.optionalIngredient.addAll(optionalIngredient);
	}
	
	public void setOptionalIngredient(ArrayList<Ingredient> optionalIngredient) {
		this.optionalIngredient=optionalIngredient;
	}
	
	public List<Ingredient> getOptionalIngredient() {
		return this.optionalIngredient;
	}

}
