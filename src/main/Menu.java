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
		
		Verification(4);
		if(choix == 1) {
			//Choix du mode de jeu (entre niveaux et mode infini)
			Main.jeu(true);
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
	
	public static int Verification(int nbChoix){
		try {
			sc = new Scanner(System.in);
			while((choix = sc.nextInt())>nbChoix || choix<0) {}	
			
		} catch (InputMismatchException e) {
			System.out.println("Tu ne peux pas mettre de lettres!");
			Verification(nbChoix);
		}
		return choix;
	}
	
	public static int SelectNiveau() {
		PrintTools.clearScreen();
		PrintTools.printPath("/src/main/Selection.txt");
		Verification(5);
		if(choix == 1) {
			//niveau 1
		} else if (choix == 2) {
			//niveau 2
		} else if (choix == 3) {
			//niveau 3
		} else if(choix == 4){
			Main.jeu(true);
		}	else if (choix == 5){
			start();
		}
		return choix;
	}

}
