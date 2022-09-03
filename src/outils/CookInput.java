package outils;
import java.util.List;
import java.util.Scanner;

public class CookInput {
	private static Scanner keyboard = new Scanner(System.in);
	
	public static boolean isCorrect(Order plat) {
		String input = keyboard.nextLine();
		return isCorrect(plat, input);
	}
	
	public static boolean isCorrect(Order plat, String input) {
		if (plat == null) {
			return false;
		}
		
		List<Ingredient> correctOrder = plat.getIngredients();
		
		if (input == null || input.length() != correctOrder.size()) {
			return false;
		}
		
		for (int car = 0; car < input.length(); car++) {
			if (input.charAt(car) != correctOrder.get(car).getShortcut()) {
				return false;
			}
		}
		
		return true;
	}
}
