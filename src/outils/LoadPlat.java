package outils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadPlat {
	
	public static ArrayList<Plat> loadListePlat(){
		String path = System.getProperty("user.dir")+"/donnees/";
		ObjectMapper om = new ObjectMapper();
		ArrayList<Plat> plats = new ArrayList<>();

		try {
			plats.addAll(om.readValue(new File(path+"/json/ListePlats.json"), new TypeReference<List<Plat>>() {}));
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
		return plats;
		}
		
		public static void printPlat() {

			ArrayList<Plat> liste = loadListePlat();
			int cpt = 0;
			while(cpt < 10 && cpt <liste.size() && !liste.isEmpty()){
				System.out.println(liste.get(cpt).getName()+"\n Ingredients obligatoires"+liste.get(cpt).getIngredientsObligatoires()+"\n Ingredients optionnels"+liste.get(cpt).getIngredientsOptionnels());
				cpt++;
			}
		}

	public static void main(String[] args) {
		printPlat();
	}
}
