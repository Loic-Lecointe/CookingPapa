package outils;

public enum Ingredient {
	
	PATE_A_PIZZA("pate a pizza",'p'),
	SAUCE_TOMATE("sauce tomate",'s'),
	
	PAIN("pain",'n'),
	STEAK("steak",'k'),
	
	TORTILLA("tortilla",'l'),
	BOEUF("boeuf",'b'),
	
	VIANDE_A_KEBAB("viande a kebab",'k'),
	
	JAMBON("jambon",'j'),
	CHAMPIGNON("champignon",'g'),
	CHORIZO("chorizo",'z'),
	FROMAGE("fromage",'f'),
	ANANAS("ananas",'a'),
	MOZARELLA("mozarella",'m'),
	SAUCISSE_DE_TOULOUSE("saucisse de Toulouse",'d'),
	SALADE("salade",'s'),
	TOMATE("tomate",'t'),
	EPICE("epice",'e'),
	PIMENT("piment",'i'),
	OIGNON("oignon",'o'),
	RIZ("riz",'r'),
	CORNICHON("cornichon",'c'),
	FRITE("frite",'f');
	
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
