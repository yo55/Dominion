package dominion.card;
import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {
	
	/**
	 * Constructeur
	 * @param string nom de la carte victoire
	 * @param i coût de la carte victoire
	 */
	public VictoryCard(String string, int i) {
		super(string, i);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#victoryValue(dominion.Player)
	 */
	public abstract int victoryValue(Player p);
	
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		// On ne joue pas les cartes Victoires
	}
}