package outils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadReceipes {
	
	private static ArrayList<Receipe> loadReceipes(boolean isHot) {
		String path = System.getProperty("user.dir")+"/donnees/";
		ObjectMapper om = new ObjectMapper();
		ArrayList<Receipe> receipes = new ArrayList<>();

		try {
			receipes.addAll(om.readValue(new File(path+"/json/AmericanOrders.json"), new TypeReference<List<Receipe>>() {}));
			for (int i = 0; i < receipes.size(); i++) {
				// TODO: Pas très beau ça serait bien de l'améliorer
				if (isHot) {
					if (!receipes.get(i).getIsHot()) {
						receipes.remove(i);
					}
				} else {
					if (receipes.get(i).getIsHot()) {
						receipes.remove(i);
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
		return receipes;
	}
	
	public static ArrayList<Receipe> loadColdReceipes(){
		return loadReceipes(false);
	}
	
	public static ArrayList<Receipe> loadHotReceipes(){
		return loadReceipes(true);
	}
}