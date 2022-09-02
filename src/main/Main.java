package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import outils.*;

public class Main {
	
	static Orders orders = new Orders();
	static int totalOrders = 0;
	public static final int NB_ORDERS_GAME = 5;
	public static int completedOrders = 0;
	
	private static int plats_reussi;
	private static int plats_echoue;
	
	public static void main(String[] args) {
		
		LocalDateTime debutDuJeu = LocalDateTime.now();
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		for(Ingredient e : Ingredient.values()) {
			ingredients.add(e);
		}
		
		while (!isFinished()) {
			
			ActionInput it = new ActionInput();
			it.start();
			
			Date date;
			Date refreshDate = new Date();
			Date orderDate = new Date();
			
			double randomTime = Math.random() * 7 + 5;
			
			while (it.getInput() == null && !isFinished()) {
				date = new Date();
				
				if (date.getTime() - orderDate.getTime() > randomTime * 1000) {
					randomTime = Math.random() * 3 + 2;
					orderDate = date;
					Plat plat = new Plat("Pizza",100,ingredients);
					if (totalOrders < NB_ORDERS_GAME && orders.add(plat)) {
						totalOrders++;
					}
				}
				
				if (date.getTime() - refreshDate.getTime() > 1000) {
					refreshDate = date;				
					printHUD();
				}
			}
			
			if (it.getInput() != null) {
				try {
					takeOrder(Integer.valueOf(it.getInput()) - 1);
				} catch (NumberFormatException e) {}
				printHUD();
			}
		}
		
		LocalDateTime finDuJeu = LocalDateTime.now();
		System.out.println("Fin");
		Calcul_score score = new Calcul_score(debutDuJeu, finDuJeu, plats_reussi, plats_echoue,5);
		System.out.println("Votre score est de :" + score.calcul_score_final(false));
	}
	
	public static void printHUD() {
		orders.removeDelayedOrders();
		clearScreen();
		System.out.println("Commandes:");
		System.out.println(orders);
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
	
	public static boolean isFinished() {
		return totalOrders == NB_ORDERS_GAME && orders.getNbOrders() == 0;
	}
}
