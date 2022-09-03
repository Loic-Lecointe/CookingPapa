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
	
	public static ArrayList<Receipe> loadListePlat(){
		String path = System.getProperty("user.dir")+"/donnees/";
		ObjectMapper om = new ObjectMapper();
		ArrayList<Receipe> receipes = new ArrayList<>();

		try {
			receipes.addAll(om.readValue(new File(path+"/json/ListePlats.json"), new TypeReference<List<Receipe>>() {}));
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
}