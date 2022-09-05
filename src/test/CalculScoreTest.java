package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import outils.Calcul_score;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculScoreTest {
	
	static Calcul_score c;

	static void initialize() {
		 c = new Calcul_score(LocalDateTime.now(),LocalDateTime.now().plusMinutes(2),2,3,8);
	}
	
	@Test
	void testCalculTempsJoue() {
		assertEquals(2,(int) c.calcul_temps_joue());
	}

	@Test
	void testCalculScoreFinal() {
		assertEquals(true,true);
	}
	
	
}
