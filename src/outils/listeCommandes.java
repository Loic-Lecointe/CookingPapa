package outils;
import java.util.ArrayList;

public class listeCommandes {
	private ArrayList<MealOrder> commandes;
	
	public listeCommandes() {
		commandes = new ArrayList<MealOrder>();
	}
	
	public void afficherListe() {
		for(int i = 0; i<commandes.size(); i++) {
			System.out.println("Plat n�"+i+" : "+commandes.get(i).toString()+".");
		}
	}
	
	public void ajouterPlat(MealOrder p) {
		commandes.add(p);
	}
	
	public void retirerPlat() {
		commandes.remove(0);
	}
}
