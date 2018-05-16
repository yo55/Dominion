package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Province
 * 
 * 6 VP
 */
public class Province extends VictoryCard {
	
	/**
	 * Constructeur Province
	 */
	public Province() { 
		super("Province", 8);	
	}
	
	/**
	 * @see dominion.card.VictoryCard#victoryValue(dominion.Player)
	 */
	public int victoryValue(Player p) {
		return 6;
	}
}