package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {

	public VictoryCard(String string, int i) {
		// TODO Auto-generated constructor stub
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