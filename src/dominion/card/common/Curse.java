package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Malédiction (Curse)
 * 
 * -1 VP
 */
public class Curse extends CurseCard {
	
	/**
	 * Constructeur cartes malédiction
	 */
	public Curse() { 
		super("Curse", 0);	
	}
	
	/**
	 * @see dominion.card.CurseCard#victoryValue(dominion.Player)
	 */
	public int victoryValue(Player p) {
		return -1;
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		// on ne joue pas les cartes malédiction
	}
}