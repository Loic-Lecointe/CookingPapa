package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import outils.*;

public class Main {
	
	static Orders orders = new Orders();
	public static final int NB_ORDERS_GAME = 5;
	public static int completedOrders = 0;
	static Scanner sc = new Scanner(System.in);
	private static int plats_reussi;
	private static int plats_echoue;
	
	public static void main(String[] args) {
		
		LocalDateTime debutDuJeu = LocalDateTime.now();
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		for(Ingredient e : Ingredient.values()) {
			ingredients.add(e);
		}
		
		int totalOrders = 0;
		
		while (completedOrders <= NB_ORDERS_GAME) {
			
			ActionInput it = new ActionInput();
			it.start();
			
			Date oldDate = new Date(), date;
						
			while (it.getInput() == null) {
				date = new Date();

				if (date.getTime() - oldDate.getTime() > 1000) {
					oldDate = date;
					
					orders.removeDelayedOrders();
					
					Plat plat = new Plat("Pizza",100,ingredients);
					if (totalOrders <= NB_ORDERS_GAME && orders.add(plat)) {
						totalOrders++;
					}
					
					clearScreen();
					System.out.println("Commandes:");
					System.out.println(orders);
				}
			}
			
			takeOrder(Integer.valueOf(it.getInput()) - 1);
		}
		LocalDateTime finDuJeu = LocalDateTime.now();
		System.out.println("Fin");
		Calcul_score score = new Calcul_score(debutDuJeu, finDuJeu, plats_reussi, plats_echoue,5);
		System.out.println("Votre score est de :" + score.calcul_score_final(false));
	}
	
	public static void takeOrder(int index) {
		Plat order = orders.get(index);
		
		System.out.println("Plat: " + order.getName());
		System.out.println("Ingrédients: " + order.getIngredients() + "\n");
		
		System.out.println("Liste des inputs:");
		System.out.println(order.getIngredientsShortcut());
		completedOrders++;
		String finish = "";
		if(CookInput.isCorrect(order)) {
			plats_reussi++;
			finish = "Bravo vous avez reussi";
		}else {
			plats_echoue++;
			finish = "Tu es null";
		}
		orders.remove(index);
		System.out.println(finish);
	}
	
	public static void clearScreen() {
		for (int i = 0; i < 40; i++) {
			System.out.println();
		}
	}
	
}
