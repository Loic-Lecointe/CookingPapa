package main;

import java.util.ArrayList;
import java.util.Scanner;

import outils.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		for(Ingredient e : Ingredient.values()) {
			ingredients.add(e);
		}
		
		Plat plat = new Plat("Pizza",100,ingredients);
		System.out.println("Commade n1 : " + plat.toString());
		System.out.println("Listes des inputs :");
		for(int i = 0; i < plat.getIngredients().size();i++) {
			System.out.println(plat.getIngredients().get(i));
		}
		String finish = "";
		finish = CookInput.isCorrect(plat)?"Bravo vous avez réussi":"Vous avez perdu";
		System.out.println(finish);
	}
	
}
