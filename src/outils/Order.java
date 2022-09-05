package outils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Order {
	private final static int TIME_BEFORE_LEAVING = 30;
	protected final Date time_start = new Date();
	
	private final Receipe receipe;
	
	private List<Ingredient> ingredients;
	
	public Order(Receipe receipe) {
		this.receipe= receipe; 
		this.ingredients = new ArrayList<>();
		generateIngredients(5);
	}
	
	public void generateIngredients(int difficulte) {
		Random rdm = new Random();
		int nb = rdm.nextInt(difficulte);
		this.ingredients.addAll(receipe.getMandatoryIngredients());
		for(int i = 0; i<nb; i++) {
			if (receipe.getOptionalIngredients().size() != 0) {
				this.ingredients.add(receipe.getOptionalIngredients().get(rdm.nextInt(receipe.getOptionalIngredients().size())));
			}
		}
	}
	
	public String getName() {
		return receipe.getName();
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public int getPoints() {
		// TODO: Créer un système de points automatique
		return -1;
	}

	@Override
	public String toString() {
		return getName() + " " + getTimeBeforeLeaving() + "s";
	}
	
	public String getIngredientsShortcut() {
		StringBuilder res = new StringBuilder();
		
		res.append("\n┉┉┉ Ingrédients obligatoires ┉┉┉\n");
		
		for(Ingredient ingredient : receipe.getMandatoryIngredients()) {
			res.append(ingredient + "\n");
		}
		
		res.append("\n┉┉┉ Ingrédients supplémentaires ┉┉┉\n");
		
		for(Ingredient ingredient : receipe.getOptionalIngredients()) {
			res.append(ingredient + "\n");
		}
		
		return res.toString();
	}
	
	public long getTimeBeforeLeaving() {
		Date now = new Date();
		return TIME_BEFORE_LEAVING - (now.getTime() - time_start.getTime()) / 1000;
	}
	
	public boolean isDelayed() {
		return getTimeBeforeLeaving() <= 0;
	}
	
	public boolean isHot() {
		return false;
	}
}
