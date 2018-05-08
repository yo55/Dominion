import java.util.*;
import dominion.*;
import dominion.card.*;
import dominion.card.base.*;

/**
 * Classe pour l'exécution d'une partie de Dominion
 */
class Main {
	public static void main(String[] args) {
		// Noms des joueurs de la partie
		// (le nombre total de joueurs correspond au nombre de noms dans le 
		// tableau)
		String[] playerNames = new String[]{"Marco", "Polo"};
		
		// Prépare les piles "royaume" de la réserve (hors cartes communes)
		List<CardList> kingdomStacks = new ArrayList<CardList>();
		
		CardList stackVillage = new CardList();
		for (int i = 0; i < 10; i++) {
			stackVillage.add(new Village());
		}
		
		CardList stackCellar= new CardList();
		for (int i = 0; i < 10; i++) {
			stackCellar.add(new Cellar());
		}
		
		CardList stackChapel= new CardList();
		for (int i = 0; i < 10; i++) {
			stackChapel.add(new Chapel());
		}
		
		// Ajouter un bloc pour chaque carte royaume à utiliser
		kingdomStacks.add(stackVillage);
		kingdomStacks.add(stackCellar);
		kingdomStacks.add(stackChapel);


		
		
		// Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		g.run();
	}
}