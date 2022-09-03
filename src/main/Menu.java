package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import outils.PrintTools;
import outils.TableauScores;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static int choix = 0; 
	  
	public static void start() {
		PrintTools.clearScreen();
		
		PrintTools.printPath("/src/main/logo.txt");
		
		// printPath("/donnees/menu");
		
		Verification();
		if(choix == 1) {
			return;
		} else if (choix == 2) {
			PrintTools.clearScreen();
			PrintTools.printPath("/donnees/regles");
			System.out.print("\n\nVeuillez appuyer sur entree pour revenir au menu");
			sc = new Scanner(System.in);
			sc.nextLine();
			start();
		} else if (choix == 3) {
			PrintTools.clearScreen();
			TableauScores.printScores();
			System.out.print("\n\nVeuillez appuyer sur entree pour revenir au menu");
			sc = new Scanner(System.in);
			sc.nextLine();
			start();

		} else {
			System.out.println("Au revoir");
			sc.close();
			System.exit(0);
		}
	}
	
	public static int Verification(){
		try {
			sc = new Scanner(System.in);
			while((choix = sc.nextInt())>4 || choix<0) {}	
			
		} catch (InputMismatchException e) {
			System.out.println("Tu ne peux pas mettre de lettres!");
			Verification();
		}
		return choix;
	}

}
