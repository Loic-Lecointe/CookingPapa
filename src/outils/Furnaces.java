package outils;

public class Furnaces {
	private final static int MAX_FURNACES = 5;
	private HotMealOrder[] food = new HotMealOrder[MAX_FURNACES];
	
	public MealOrder get(int index) {
		return food[index];
	}
	
	public boolean add(HotMealOrder order) {
		int i = 0; 
		while (i < food.length && food[i] != null) i++;
		
		if (i < food.length) {
			food[i] = order;
			return true;
		}
		return false;
	}
	
	public void remove(MealOrder order) {
		int i = 0;
		while (i < food.length && food[i] != order) i++;
		if (i < food.length) {
			food[i] = null;
		}
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < MAX_FURNACES; i++) {
			res.append("- ");
			if (food[i] != null) {
				res.append(food[i].getName() + " " + food[i].getProgressBar());
			} else {
				res.append("_________");
			}
			res.append("\n");
		}
		return res.toString();
	}
}
