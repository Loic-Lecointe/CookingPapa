package outils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TableauScores {

	public static void saveScores(ArrayList<Player> scores) {
		String path = System.getProperty("user.dir")+"/donnees/";
		ObjectMapper om = new ObjectMapper();
		Collections.sort(scores);
		try {
			om.writeValue(new File(path+"/json/tabScores.json"),scores);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}


	public static ArrayList<Player> loadScores(){
		
		String path = System.getProperty("user.dir")+"/donnees/json/tabScores.json";
		File f = new File(path);
		ArrayList<Player> scores = new ArrayList<>();
		if(f.exists() && !f.isDirectory()) {
			ObjectMapper om = new ObjectMapper();
			try {
				scores.addAll(om.readValue(f, new TypeReference<List<Player>>() {}));
			} catch (StreamReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
	
			} catch (DatabindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			
				System.exit(0);
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
	
			}
		}

		return scores;

	}

	public static void printScores() {
		String path = System.getProperty("user.dir")+"/donnees/json/tabScores.json";
		File f = new File(path);
		if(f.exists() && !f.isDirectory()) { 
			ArrayList<Player> liste = loadScores();
			int cpt = 0;
			while(cpt < 10 && cpt <liste.size() && !liste.isEmpty()){
				System.out.println("Joueur "+(cpt+1)+" : "+liste.get(cpt).getName()+"\t"+liste.get(cpt).getScore()+" points");
				cpt++;
			}
		}else {
			System.out.println("Aucun score n'a encore ete enregistre. Terminez une partie pour commencer a remplir le leaderboard !");
		}

	}

	public static void deleteScores() {
		try  
		{         
			String path = System.getProperty("user.dir")+"/donnees/";
			File f = new File(path+"/json/tabScores.json"); 
			if(f.delete())  
			{  
				System.out.println(f.getName() + " deleted");   //getting and printing the file name  
			}  
			else  
			{  
				System.out.println("Score deletion has failed");  
			}  
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
	}





	public static void main(String[] args) {
		printScores();
	}
}
