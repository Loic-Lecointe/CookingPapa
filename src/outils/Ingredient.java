package outils;

public enum Ingredient {

	PATE_A_PIZZA("p�te � pizza",'p'), SAUCE_TOMATE("sauce tomate",'s'), JAMBON("jambon",'j'), CHAMPIGNON("champignon",'c');
	
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
