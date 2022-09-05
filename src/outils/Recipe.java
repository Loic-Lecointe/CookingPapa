package outils;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	private final String name;
	private final List<Ingredient> mandatoryIngredients;
	private final List<Ingredient> optionalIngredients;
	private final boolean isHot;
	
	public Recipe(String name, List<Ingredient> mandatoryIngredients, List<Ingredient> optionalIngredients, boolean isHot) {
		this.name = name;
		this.mandatoryIngredients = new ArrayList<>(mandatoryIngredients);
		this.optionalIngredients = new ArrayList<>(optionalIngredients);
		this.isHot = isHot;
	}
	
	public Recipe(String name, List<Ingredient> mandatoryIngredients, boolean isHot) {
		this(name, mandatoryIngredients, new ArrayList<>(), isHot);
	}
	
	public Recipe() {
		this(null, new ArrayList<>(), false);
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
	
	public boolean getIsHot() {
		return isHot;
	}
	
	public Order createOrder() {
		if (isHot) {
			return new HotOrder(this);
		}
		return new Order(this);
	}
}
