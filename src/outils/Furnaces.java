package outils;

public class Furnaces {
	private final static int MAX_FURNACES = 5;
	private HotOrder[] food = new HotOrder[MAX_FURNACES];
	
	public Order get(int index) {
		return food[index];
	}
	
	public boolean add(HotOrder order) {
		int i = 0; 
		while (i < food.length && food[i] != null) i++;
		
		if (i < food.length) {
			food[i] = order;
			return true;
		}
		return false;
	}
	
	public void remove(Order order) {
		int i = 0;
		while (i < food.length && food[i] != order) i++;
		
		if (i < food.length) {
			food[i] = null;
		}
	}
	
	public void remove(int index) {
		if (food[index] != null) {
			food[index] = null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < MAX_FURNACES; i++) {
			res.append((char) (i+'a') + ": ");
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
