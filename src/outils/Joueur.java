package outils;

public class Joueur implements Comparable<Joueur>{
	private String name;
	private int score;
	
	
	public Joueur(String name, int score) {
		this.name = name;
		this.score = score;
	}



	public String getName() {
		return name;
	}


	public int getScore() {
		return score;
	}


	@Override
	public String toString() {
		return name + " " + score;
	}
	
	@Override
	public int compareTo(Joueur j) {
		return (j.score-this.score);
	}
	
	
}
