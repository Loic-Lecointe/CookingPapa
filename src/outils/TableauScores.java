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

	public static void saveScores(ArrayList<Joueur> scores) {
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


	public static ArrayList<Joueur> loadScores(){
		String path = System.getProperty("user.dir")+"/donnees/";
		ObjectMapper om = new ObjectMapper();
		ArrayList<Joueur> scores = new ArrayList<>();

		try {
			scores.addAll(om.readValue(new File(path+"/json/tabScores.json"), new TypeReference<List<Joueur>>() {}));
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


		return scores;

	}

	public static void printScores() {

		ArrayList<Joueur> liste = loadScores();
		int cpt = 0;
		while(cpt < 10 && cpt <liste.size() && !liste.isEmpty()){
			System.out.println("Joueur "+(cpt+1)+" : "+liste.get(cpt).getName()+"\t"+liste.get(cpt).getScore()+" points");
			cpt++;
		}
	}





	public static void main(String[] args) {
		printScores();
	}
}
