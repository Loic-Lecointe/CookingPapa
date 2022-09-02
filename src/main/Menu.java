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
		public static void menuPrincipal() {
			for(int i = 0; i < 5; i++) {
				System.out.println();
			}
			
			printPath("/donnees/menu");
			
			while((choix = sc.nextInt())>4 || choix<0) {}			

			if(choix == 1) {
				return;
			} else if (choix == 2) {
				printPath("/donnees/regles");
			} else if (choix == 3) {
				TableauScores.printScores();
			} else {
				System.out.println("Au revoir");
				System.exit(0);
			}
		}
		
		public static void AfficherLogo() {
		String path = System.getProperty("user.dir")+"/src/main/";
		try (FileInputStream fstream =new FileInputStream(path+"logo.txt");BufferedReader br = new BufferedReader(new InputStreamReader(fstream));){
			String strLine;

			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			    // Print the content on the console - do what you want to do
			    System.out.println (strLine);
			  }

			  //Close the input stream
			  fstream.close();
			  menuPrincipal();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(0);

		}
		
		  
	  }
	  
	public static void start() {
		AfficherLogo();
	}
	
	public static void main(String[] args) {
		start();
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
