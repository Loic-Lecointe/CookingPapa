package outils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MealOrder {
	private final static int TIME_BEFORE_LEAVING = 30;
	protected final Date time_start = new Date();
	
	private final Recipe recipe;
	
	private List<Ingredient> ingredients;
	
	public MealOrder(Recipe recipe) {
		this.recipe= recipe; 
		this.ingredients = new ArrayList<>();
		generateIngredients(5);
	}
	
	public void generateIngredients(int difficulte) {
		Random rdm = new Random();
		int nb = rdm.nextInt(difficulte);
		this.ingredients.addAll(recipe.getMandatoryIngredients());
		for(int i = 0; i<nb; i++) {
			if (recipe.getOptionalIngredients().size() != 0) {
				this.ingredients.add(recipe.getOptionalIngredients().get(rdm.nextInt(recipe.getOptionalIngredients().size())));
			}
		}
	}
	
	public String getName() {
		return recipe.getName();
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	@Override
	public String toString() {
		return getName() + " " + getTimeBeforeLeaving() + "s";
	}
	
	public String getIngredientsShortcut() {
		StringBuilder res = new StringBuilder();
		
		res.append("\n┉┉┉ Ingredients obligatoires ┉┉┉\n");
		
		for(Ingredient ingredient : recipe.getMandatoryIngredients()) {
			res.append(ingredient + "\n");
		}
		
<<<<<<< HEAD
		if (receipe.getOptionalIngredients().size() != 0) {
			res.append("\n┉┉┉ Ingredients supplementaires ┉┉┉\n");
=======
		if (recipe.getOptionalIngredients().size() != 0) {
			res.append("\n┉┉┉ Ingrédients supplémentaires ┉┉┉\n");
>>>>>>> branch 'main' of https://gitlab.univ-lille.fr/2022-projet-agile-de-rentree/groupe-15.git
		}
		
		for(Ingredient ingredient : recipe.getOptionalIngredients()) {
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
	
	public int maxLengthIngredients() {
		int max = 0;
		for (Ingredient ingredient: getIngredients()) {
			if (ingredient.getName().length() > max) {
				max = ingredient.getName().length();
			}
		}
		return max;
	}
	
	public String repeatCar(int length, char car) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < length; i++) {
			res.append(car);
		}
		return res.toString();
	}
	
	public String toStringIngredients() {
		StringBuilder res = new StringBuilder();
		
		int size = 40;
		
		res.append("┏");
		res.append(repeatCar(size, '━'));
		res.append("┓\n");
		res.append("┃Ingredients:");
		res.append(repeatCar(size - "┃Ingredients:".length() + 1, ' ') + "┃\n");
		
		res.append("┣" + repeatCar(size, '━') + "┫\n");
		
		for (Ingredient ingredient: getIngredients()) {
			res.append("┃ - " + ingredient.getName() + repeatCar(size - ("┃ - " + ingredient.getName()).length() + 1, ' ') + "┃\n");
		}
		
		res.append("┗");
		res.append(repeatCar(size, '━'));
		res.append("┛\n");
		
		return res.toString();
	}
}
