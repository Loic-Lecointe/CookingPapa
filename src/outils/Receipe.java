package outils;

import java.util.ArrayList;
import java.util.List;

public class Receipe {
	private final String name;
	private final List<Ingredient> mandatoryIngredients;
	private final List<Ingredient> optionalIngredients;
	
	public Receipe(String name, List<Ingredient> mandatoryIngredients, List<Ingredient> optionalIngredients) {
		this.name = name;
		this.mandatoryIngredients = new ArrayList<>(mandatoryIngredients);
		this.optionalIngredients = new ArrayList<>(optionalIngredients);
	}
	
	public Receipe(String name, List<Ingredient> mandatoryIngredients) {
		this(name, mandatoryIngredients, new ArrayList<>());
	}
	
	public Receipe() {
		this(null, new ArrayList<>());
	}
	
	public String getName() {
		return name;
	}

	public List<Ingredient> getMandatoryIngredients() {
		return new ArrayList<>(mandatoryIngredients);
	}

	public List<Ingredient> getOptionalIngredients() {
		return new ArrayList<>(optionalIngredients);
	}
}
