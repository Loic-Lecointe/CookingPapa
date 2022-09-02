package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	
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
}
