package outils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadRecipes {
	
	private static ArrayList<Recipe> loadrecipes(boolean isHot, int niveau) {
		String path = System.getProperty("user.dir")+"/donnees/";
		ObjectMapper om = new ObjectMapper();
		ArrayList<Recipe> recipes = new ArrayList<>();

		try {
			if(niveau == 1) {
				recipes.addAll(om.readValue(new File(path+"/json/AsianOrders.json"), new TypeReference<List<Recipe>>() {}));
			} else if (niveau == 2) {
				recipes.addAll(om.readValue(new File(path+"/json/EuropeOrders.json"), new TypeReference<List<Recipe>>() {}));
			} else if (niveau == 3){
				recipes.addAll(om.readValue(new File(path+"/json/AmericanOrders.json"), new TypeReference<List<Recipe>>() {}));

			} else {
				recipes.addAll(om.readValue(new File(path+"/json/AmericanOrders.json"), new TypeReference<List<Recipe>>() {}));
				recipes.addAll(om.readValue(new File(path+"/json/AsianOrders.json"), new TypeReference<List<Recipe>>() {}));
				recipes.addAll(om.readValue(new File(path+"/json/EuropeOrders.json"), new TypeReference<List<Recipe>>() {}));
			}
			for (int i = 0; i < recipes.size(); i++) {
				// TODO: Pas très beau ça serait bien de l'améliorer
				if (isHot) {
					if (!recipes.get(i).getIsHot()) {
						recipes.remove(i);
					}
				} else {
					if (recipes.get(i).getIsHot()) {
						recipes.remove(i);
					}
				}
			}
		} catch (StreamReadException e) {
			e.printStackTrace();
			System.exit(0);

		} catch (DatabindException e) {
			e.printStackTrace();			
			System.exit(0);

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return recipes;
	}
	
	public static ArrayList<Recipe> loadColdrecipes(int niveau){
		return loadrecipes(false,niveau);
	}
	
	public static ArrayList<Recipe> loadHotrecipes(int niveau){
		return loadrecipes(true,niveau);
	}
}