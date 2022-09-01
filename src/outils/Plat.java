package outils;

import java.util.ArrayList;
import java.util.List;

public class Plat {
	private static int cpt = 0;
	private int id;
	private String name;
	private List<Ingredient> ingredients;
	private int points;
	
	public Plat(String name, int points) {
		id = cpt++;
		this.name = name;
		this.ingredients = new ArrayList<>();
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Plat [id=" + id + ", name=" + name + ", ingredients=" + ingredients + ", points=" + points + "]";
	}

	
	
	
}
