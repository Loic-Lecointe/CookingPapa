package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import outils.TableauScores;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static int choix = 0; 
	  
	public static void start() {
		Main.clearScreen();
		
		printPath("/src/main/logo.txt");
		
		printPath("/donnees/menu");
		
		Verification();
		if(choix == 1) {
			return;
		} else if (choix == 2) {
			Main.clearScreen();
			printPath("/donnees/regles");
			System.out.print("\n\nVeuillez appuyer sur entree pour revenir au menu");
			sc = new Scanner(System.in);
			sc.nextLine();
			start();
		} else if (choix == 3) {
			Main.clearScreen();
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
	
	
	/**
	 * Method to print a file
	 * @param file
	 */
	public static void printPath(String file) {
		Path path = Paths.get(System.getProperty("user.dir")+file);
		try {
			for(String ligne : Files.readAllLines(path)) {
				System.out.println(ligne);
			}
		} catch (IOException e) {
			e.printStackTrace();
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
