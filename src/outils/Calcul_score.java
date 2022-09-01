package outils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Calcul_score {
	private LocalDateTime time_start;
	private LocalDateTime time_end;
	private int score;
	private int plats_reussi;
	private int plats_echoue;
	
	public Calcul_score(LocalDateTime time_start, LocalDateTime time_end, int score, int plats_reussi, int plats_echoue) {
		this.time_start = time_start;
		this.time_end = time_end;
		this.score = score;
		this.plats_reussi = plats_reussi;
		this.plats_echoue = plats_echoue;
	}
	
	public long calcul_temps_joue(LocalDateTime time_start, LocalDateTime time_end) {
		long temps_de_jeu = time_start.until(time_end, ChronoUnit.SECONDS);
		return temps_de_jeu;
	}
	

	public int getScore() {
		return score;
	}

	public void calcul_score_final() {
	}
}
