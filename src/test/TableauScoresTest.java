package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import outils.Player;
import outils.TableauScores;

public class TableauScoresTest {
	
	static ArrayList<Player> joueurs;
	
	@BeforeAll
	static void initialize() {
		Player joueur1 = new Player("Thomas", 3);
		Player joueur2 = new Player("Tanguy", 7);
		joueurs = new ArrayList<Player>();
		joueurs.add(joueur1);
		joueurs.add(joueur2);
	}
	
	@Test
	void test() {
		TableauScores.deleteScores();
		TableauScores.saveScores(joueurs);
		ArrayList<Player> joueursSerialised = TableauScores.loadScores();
		assertEquals(joueurs.get(0).getName(),joueursSerialised.get(0).getName());
		assertEquals(joueurs.get(0).getScore(),joueursSerialised.get(0).getScore());
		assertEquals(joueurs.get(1).getName(),joueursSerialised.get(1).getName());
		assertEquals(joueurs.get(1).getScore(),joueursSerialised.get(1).getScore());
		TableauScores.deleteScores();
	}
}
