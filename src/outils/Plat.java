package outils;

import java.util.ArrayList;

public class Plat {
	private static int cpt = 0;
	private int id;
	private String name;
	private ArrayList<Ingredient> ingredients;
	private int points;
	
	public Plat(String name, int points, ArrayList<Ingredient> ingredients) {
		id = cpt++;
		this.name = name;
		this.ingredients = ingredients;
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

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
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
