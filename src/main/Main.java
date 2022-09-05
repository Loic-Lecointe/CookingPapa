package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import outils.*;

public class Main {
	static List<Receipe> receipeList = LoadReceipes.loadColdReceipes();
	static List<Receipe> hotReceipeList = LoadReceipes.loadHotReceipes();
	static Orders orders = new Orders();
	static Furnaces furnaces = new Furnaces();
	static int totalOrders = 0;
	public static final int NB_ORDERS_GAME = 5;
	public static int completedOrders = 0;
	private static int nbLife = 3;
	private static int plats_reussi;
	private static int plats_echoue;
	
	public static void main(String[] args) {
		receipeList.addAll(hotReceipeList);
		Menu.start();
		
		LocalDateTime debutDuJeu = LocalDateTime.now();
		
		while (!isFinished()) {
			
			ActionInput it = new ActionInput();
			it.start();
			
			Date date;
			Date refreshDate = new Date();
			Date orderDate = new Date();
			
			System.out.println(hotReceipeList.get(0).createOrder());
			furnaces.add((HotOrder) hotReceipeList.get(0).createOrder());
			
			// Ajoute quelques plats à servir au début de la partie
			for (int i = 0; i < Math.random() * 3 + 1; i++)	
				addNewOrder();
			
			double randomTime = Math.random() * 7 + 5;
			
			printHUD();
			
			while (it.getInput() == null && !isFinished()) {
				date = new Date();
				
				if (date.getTime() - orderDate.getTime() > randomTime * 1000) {
					randomTime = Math.random() * 3 + 2;
					orderDate = date;
					addNewOrder();
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
		sc.close();
	}
	
	private static void addNewOrder() {
		
		Random rdm = new Random();
		Order order = receipeList.get(rdm.nextInt(receipeList.size())).createOrder();
		
		if (totalOrders < NB_ORDERS_GAME && orders.add(order)) {
			totalOrders++;
		}
	}

	public static void printHUD() {
		nbLife -= orders.removeDelayedOrders();
		PrintTools.clearScreen();
		System.out.println("Fours:");
		System.out.println(furnaces);
		System.out.println("Commandes:");
		System.out.println(orders);
		printFoodTruck();
	}
	
	public static void printFoodTruck() {
		List<String> truck = PrintTools.pathToString("/donnees/foodtruck");
		
		for (int i = 0; i < orders.getNbOrders(); i++) {
			List<String> client = PrintTools.pathToString("/donnees/customer");
			for (int j = 0; j < client.size(); j++) {
				truck.add(j, truck.get(j) + client.get(j));
				truck.remove(j+1);
			}
		}
		
		for (String ligne: truck) {
			System.out.println(ligne);
		}
	}
	
	public static void takeOrder(int index) {
		Order order = orders.get(index);
		
		PrintTools.clearScreen();
		
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
			nbLife--;
			plats_echoue++;
			finish = "Tu es nul";
		}
		orders.remove(index);
		System.out.println(finish);
	}
	
	public static boolean isFinished() {
		return (totalOrders == NB_ORDERS_GAME && orders.getNbOrders() == 0) || nbLife==0;
	}
	
	
	
	public static void jeu(boolean infini) {
		LocalDateTime debutDuJeu = LocalDateTime.now();
		
		if(infini) {
			playGame();
		} else {
			while(nbLife>0) {
				playGame();
			}
		}
		
		LocalDateTime finDuJeu = LocalDateTime.now();
		System.out.println("Fin");
		Calcul_score score = new Calcul_score(debutDuJeu, finDuJeu, plats_reussi, plats_echoue,5);
		System.out.println("Votre score est de : " + score.calcul_score_final(false));
		if(infini) {
			System.out.println("Entrez un nom ou un pseudo pour etre enregistre sur le leaderboard :");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			ArrayList<Joueur> leaderboard = TableauScores.loadScores();
			leaderboard.add(new Joueur(input,score.calcul_score_final(false)));
			TableauScores.saveScores(leaderboard);
			System.out.println("Score enregistre. Merci d'avoir joue !");
			sc.close();
		}
		
	}
	
	public static void playGame() {
		while (!isFinished()) {
			
			ActionInput it = new ActionInput();
			it.start();
			
			Date date;
			Date refreshDate = new Date();
			Date orderDate = new Date();
			
			// Ajoute quelques plats à servir au début de la partie
			for (int i = 0; i < Math.random() * 3 + 1; i++)	
				addNewOrder();
			
			double randomTime = Math.random() * 7 + 5;
			
			printHUD();
			
			while (it.getInput() == null && !isFinished()) {
				date = new Date();
				
				if (date.getTime() - orderDate.getTime() > randomTime * 1000) {
					randomTime = Math.random() * 3 + 2;
					orderDate = date;
					addNewOrder();
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
	}
	
}
