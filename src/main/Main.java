package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import outils.*;

public class Main {
	
	static Orders orders = new Orders();
	static int totalOrders = 0;
	public static final int NB_ORDERS_GAME = 5;
	public static int completedOrders = 0;
	
	private static int plats_reussi;
	private static int plats_echoue;
	
	public static void main(String[] args) {
		Menu.start();
		
		LocalDateTime debutDuJeu = LocalDateTime.now();
		
		while (!isFinished()) {
			
			ActionInput it = new ActionInput();
			it.start();
			
			Date date;
			Date refreshDate = new Date();
			Date orderDate = new Date();
			
			// Ajoute quelques plats à servir au début de la partie
			for (int i = 0; i < Math.random() * 3 + 1; i++)	
				addNewPlat();
			
			double randomTime = Math.random() * 7 + 5;
			
			printHUD();
			
			while (it.getInput() == null && !isFinished()) {
				date = new Date();
				
				if (date.getTime() - orderDate.getTime() > randomTime * 1000) {
					randomTime = Math.random() * 3 + 2;
					orderDate = date;
					addNewPlat();
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
		System.out.println("Votre score est de : " + score.calcul_score_final(false)+".\nEntrez un nom ou un pseudo pour être enregistré sur le leaderboard :");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		ArrayList<Joueur> leaderboard = TableauScores.loadScores();
		leaderboard.add(new Joueur(input,score.calcul_score_final(false)));
		TableauScores.saveScores(leaderboard);
		System.out.println("Score enregistré. Merci d'avoir joué !");
	}
	
	private static void addNewPlat() {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			ingredients.add(Ingredient.values()[i]);
		}
		Plat plat = new Plat("Pizza",100, ingredients);
		
		if (totalOrders < NB_ORDERS_GAME && orders.add(plat)) {
			totalOrders++;
		}
	}

	public static void printHUD() {
		orders.removeDelayedOrders();
		clearScreen();
		System.out.println("Commandes:");
		System.out.println(orders);
	}
	
	public static void takeOrder(int index) {
		Plat order = orders.get(index);
		
		clearScreen();
		
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
