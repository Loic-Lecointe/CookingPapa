package main;

import java.util.ArrayList;

import outils.*;

public class Main {

	
	public static void main(String[] args) {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		ingredients.toArray(Ingredient.values());
		Plat plat = new Plat("Pizza",100,ingredients);
		
	}
	
}
