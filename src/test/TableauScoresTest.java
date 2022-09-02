package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import outils.Joueur;
import outils.TableauScores;

public class TableauScoresTest {
	
	static TableauScores tab;
	static ArrayList<Joueur> joueurs;
	
	@BeforeAll
	static void initialize() {
		Joueur joueur1 = new Joueur("Thomas", 3);
		Joueur joueur2 = new Joueur("Tanguy", 7);
		joueurs = new ArrayList<Joueur>();
		joueurs.add(joueur1);
		joueurs.add(joueur2);
		tab = new TableauScores();
		

	}
	
	@Test
	void test() {
		tab.saveScores(joueurs);
		ArrayList<Joueur> joueursSerialised = tab.loadScores();
		assertEquals(joueurs.get(0).getName(),joueursSerialised.get(0).getName());
		assertEquals(joueurs.get(0).getScore(),joueursSerialised.get(0).getScore());
		assertEquals(joueurs.get(1).getName(),joueursSerialised.get(1).getName());
		assertEquals(joueurs.get(1).getScore(),joueursSerialised.get(1).getScore());
	}
}
