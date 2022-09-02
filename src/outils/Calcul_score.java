

package outils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Calcul_score {
	private LocalDateTime time_start;
	private LocalDateTime time_end;
	private int score;
	private int plats_reussi;
	private int plats_echoue;
	private int time_objectif;
	
	public Calcul_score(LocalDateTime time_start, LocalDateTime time_end, int plats_reussi, int plats_echoue, int time_objectif) {
		this.time_start = time_start;
		this.time_end = time_end;
		this.plats_reussi = plats_reussi;
		this.plats_echoue = plats_echoue;
		this.time_objectif = time_objectif;
	}
	
	public long calcul_temps_joue() {
		long temps_de_jeu = this.time_start.until(this.time_end, ChronoUnit.SECONDS);
		return temps_de_jeu;
	}
	

	public int getScore() {
		return score;
	}

	public int calcul_score_final(boolean infinit) {
		score = 0;
		if(!infinit) {
			int temps_joue = (int)calcul_temps_joue();
			if(temps_joue < this.time_objectif * 60) {
				score = score + ((time_objectif*60) - temps_joue)*2;
			}
			if(temps_joue > this.time_objectif * 60) {
				score = score + ((time_objectif*60) - temps_joue);
			}
			for(int i =0;i < plats_reussi;i++) {
				score = score +100;
			}
			for(int i =0;i < plats_echoue;i++) {
				score = score -50;
			}
		}else {
			for(int i =0;i < plats_reussi;i++) {
				score = score +100;
			}
			for(int i =0;i < plats_echoue;i++) {
				score = score -50;
			}
		}
	
		return score;
	}
}
