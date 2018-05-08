import java.lang.reflect.InvocationTargetException;
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

		List<Class<? extends ActionCard>> kingdomCards = Arrays.asList(
				Village.class,
				Cellar.class,
				Chapel.class,
				Chancellor.class, 
				Woodcutter.class, 
				Workshop.class,
				Feast.class,
				Smithy.class,
				Remodel.class
				);
		
		for(Class<? extends ActionCard> card : kingdomCards) {
			CardList kingdomStack = new CardList();
			for(int i = 0; i < 10; i++) {
				try {
					kingdomStack.add( card.getConstructor().newInstance());
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			kingdomStacks.add(kingdomStack);
		}

	
		// Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		g.run();
	}
}