package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import outils.TableauScores;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static int choix = 0; 
	  
	public static void start() {
		Main.clearScreen();
		
		printPath("/src/main/logo.txt");
		
		printPath("/donnees/menu");
		
		while((choix = sc.nextInt())>4 || choix<0) {}			

		if(choix == 1) {
			return;
		} else if (choix == 2) {
			printPath("/donnees/regles");
			System.out.print("\n\nVeuillez appuyer sur entr�e pour revenir au menu");
			sc = new Scanner(System.in);
			sc.nextLine();
			start();
		} else if (choix == 3) {
			TableauScores.printScores();
			System.out.print("\n\nVeuillez appuyer sur entr�e pour revenir au menu");
			sc = new Scanner(System.in);
			sc.nextLine();
			start();

		} else {
			System.out.println("Au revoir");
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

}
