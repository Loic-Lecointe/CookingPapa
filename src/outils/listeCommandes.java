package outils;
import java.util.ArrayList;

public class listeCommandes {
	private ArrayList<Plat> commandes;
	
	public listeCommandes() {
		commandes = new ArrayList<Plat>();
	}
	
	public void afficherListe() {
		for(int i = 0; i<commandes.size(); i++) {
			System.out.println("Plat n°"+i+" : "+commandes.get(i).toString()+".");
		}
	}
	
	public void ajouterPlat(Plat p) {
		commandes.add(p);
	}
	
	public void retirerPlat() {
		commandes.remove(0);
	}
}
