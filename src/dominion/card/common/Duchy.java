package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Duché (Duchy)
 * 
 * 3 VP
 */
public class Duchy extends VictoryCard {
	
	/**
	 * Constructeur
	 */
	public Duchy() { 
		super("Duchy", 5);	
	}

	/**
	 * @see dominion.card.VictoryCard#victoryValue(dominion.Player)
	 */
	public int victoryValue(Player p) {
		return 3;
	}
}