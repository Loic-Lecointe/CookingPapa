package src.outils;
import java.util.ArrayList;

public class listeCommandes {
	private ArrayList<plats> commandes;
	
	public listeCommandes() {
		commandes = new ArrayList<plats>();
	}
	
	public void afficherListe() {
		for(int i = 0; i<commandes.size(); i++) {
			System.out.println("Plat n°"+i+" : "+commandes.get(i).toString()+".");
		}
	}
	
	public void ajouterPlat(plats p) {
		commandes.add(p);
	}
	
	public void retirerPlat() {
		commandes.remove(0);
	}
}
