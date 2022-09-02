package outils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"cpt","id","ingredients","points"})
public class Plat {
	private final static int TIME_BEFORE_LEAVING = 30;
	@JsonIgnore
	private static int cpt = 0;
	@JsonIgnore
	private int id;
	private String name;
	private final Date time_start = new Date();
	private List<Ingredient> ingredientsObligatoire;
	private List<Ingredient> ingredientsOptionnels;
	@JsonIgnore
	private List<Ingredient> ingredients;
	@JsonIgnore
	private int points;
	
	public Plat(String name, int points) {
		id = cpt++;
		this.name = name;
		this.ingredients = new ArrayList<>();
		this.ingredientsObligatoire = new ArrayList<>();
		this.ingredientsOptionnels = new ArrayList<>();
		this.points = points;
	}
	
	public Plat(String name, int points, ArrayList<Ingredient> ingredient) {
		this(name,points);
		this.ingredients = ingredient;
	}
	
	public Plat(String name, List<Ingredient> ingredi, List<Ingredient> optionnel) {
		this(name,0);
		this.ingredientsObligatoire = ingredi;
		this.ingredientsOptionnels = optionnel;
	}
	
	public void generateIngredients(int difficulte) {
		Random rdm = new Random();
		int nb = rdm.nextInt(difficulte);
		Ingredient[] tab = Ingredient.values();
		for(int i = 0; i<nb; i++) {
			this.ingredients.add(tab[rdm.nextInt(tab.length)]);
		}
	}
	@JsonIgnore
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public List<Ingredient> getIngredientsObligatoires(){
		return ingredientsObligatoire;
	}
	
	public void setIngredientsObligatoires(List<Ingredient> ingredients) {
		this.ingredientsObligatoire = ingredients;
	}
	
	public List<Ingredient> getIngredientsOptionnels(){
		return ingredientsOptionnels;
	}
	
	public void setIngredientsOptionnels(List<Ingredient> ingredients) {
		this.ingredientsOptionnels = ingredients;
	}
	@JsonIgnore
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Plat [id=" + id + ", name=" + name + ", ingredients=" + ingredients + ", points=" + points + "]";
	}
	
	public String getIngredientsShortcut() {
		StringBuilder res = new StringBuilder();
		
		for(int i = 0; i < getIngredients().size();i++) {
			res.append(getIngredients().get(i) + "\n");
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

}
