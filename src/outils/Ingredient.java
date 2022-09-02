package outils;

public enum Ingredient {
	PATE_A_PIZZA("pate a pizza",'p'),
	SAUCE_TOMATE("sauce tomate",'s'),
	JAMBON("jambon",'j'),
	CHAMPIGNON("champignon",'c'),
	CHORIZO("chorizo",'h'),
	FROMAGE("fromage",'f'),
	ANANAS("ananas",'a');
	
	private final String name;
	private final char shortcut;
	
	private Ingredient(String s, char c) {
		this.name=s;
		this.shortcut=c;
	}

	public char getShortcut() {
	    return shortcut;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.getShortcut() + " : " + this.getName();
	}
}
