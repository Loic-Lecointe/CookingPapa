package outils;

public class Player implements Comparable<Player>{
	private String name;
	private int score;
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public Player() {
		this(null,0);
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
	public int compareTo(Player j) {
		return (j.score-this.score);
	}
	
	
}
