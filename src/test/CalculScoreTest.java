package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import outils.Calcul_score;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculScoreTest {
	
	static Calcul_score c = new Calcul_score(LocalDateTime.now(),LocalDateTime.now().plusMinutes(2),2,3,8);

	static void initialize() {
		c.calcul_temps_joue();
	}
	
	@Test
	void testCalculTempsJoue() {
		assetEquals(c.time_start.until(this.time_end, ChronoUnit.SECONDS),c.calcul_temps_joue());
	}
	
	@Test
	void testCalculScoreFinal() {
		return true;
	}
	
	
}
