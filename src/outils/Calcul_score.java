package outils;

public class Calcul_score {
	private int time_start;
	private int time_end;
	private int score;
	private int plats_reussi;
	private int plats_echoue;
	
	public Calcul_score(int time_start, int time_end, int score, int plats_reussi, int plats_echoue) {
		this.time_start = time_start;
		this.time_end = time_end;
		this.score = score;
		this.plats_reussi = plats_reussi;
		this.plats_echoue = plats_echoue;
	}
	
	public int calcul_temps_joue(int time_start, int time_end) {
		return time_start - time_end;
	}
	
	public int calcul_plats_reussi() {
		int r = 
	}
	
	public int calcul_plats_echoue() {
		int e = 
	}
	
	
	public int getScore() {
		return score;
	}

	public void calcul_score_final() {
		
	}
}
