package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import outils.*;

public class Main {
	
	static Orders orders = new Orders();
	public static final int NB_ORDERS_GAME = 5;
	public static int completedOrders = 0;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		for(Ingredient e : Ingredient.values()) {
			ingredients.add(e);
		}
		
		int totalOrders = 0;
		
		Plat plat = new Plat("Pizza",100,ingredients);
		
		while (completedOrders < NB_ORDERS_GAME) {
			
			ActionInput it = new ActionInput();
			it.start();
			
			Date oldDate = new Date(), date;
			
			System.out.println(totalOrders);
			
			while (it.getInput() == null) {
				date = new Date();

				if (date.getTime() - oldDate.getTime() > 1000) {
					oldDate = date;
					
					if (totalOrders < NB_ORDERS_GAME && orders.add(plat)) {
						totalOrders++;
					}
					
					clearScreen();
					System.out.println(orders);
				}
			}
			
			takeOrder(Integer.valueOf(it.getInput()));
		}
		
		System.out.println("Fin");
	}
	
	public static void takeOrder(int index) {
		System.out.println("Liste des inputs:");
		System.out.println(orders.get(index).getIngredientsShortcut());
		completedOrders++;
		orders.remove(index);

		String finish = CookInput.isCorrect(orders.get(index))?"Bravo vous avez r�ussi":"Vous avez perdu";
		System.out.println(finish);
	}
	
	public static void clearScreen() {
		for (int i = 0; i < 40; i++) {
			System.out.println();
		}
	}
	
}
