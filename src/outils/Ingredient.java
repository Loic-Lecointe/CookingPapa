package outils;

public enum Ingredient {
	
	PATE_A_PIZZA("pate a pizza",'p'),
	SAUCE_TOMATE("sauce tomate",'s'),
	PAIN("pain",'n'),
	STEAK("steak",'k'),
	TORTILLA("tortilla",'l'),
	BOEUF("boeuf",'b'),
	VIANDE_A_KEBAB("viande a kebab",'h'),
	ALGUE("algue",'u'),
	RIZ("riz",'r'),
	JAMBON("jambon",'j'),
	CHAMPIGNON("champignon",'g'),
	CHORIZO("chorizo",'z'),
	FROMAGE("fromage",'f'),
	ANANAS("ananas",'a'),
	MOZARELLA("mozarella",'m'),
	SAUCISSE_DE_TOULOUSE("saucisse de Toulouse",'d'),
	SALADE("salade",'w'),
	TOMATE("tomate",'t'),
	EPICE("epice",'e'),
	PIMENT("piment",'i'),
	AVOCAT("avocat",'v'),
	POIVRON("poivron",'x'),
	CREVETTE("crevette",'y'),
	THON("thon",'q'),
	SAUMON("saumon",'f'),
	CORNICHON("cornichon",'c'),
	OIGNON("oignon",'o');
	
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
