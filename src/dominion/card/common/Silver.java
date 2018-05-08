package dominion.card.common;
import dominion.card.*;

/**
 * Carte Argent (Silver)
 * 
 * 2 Pièces
 */
public class Silver extends TreasureCard {
	
	/**
	 * Constructeur
	 */
	public Silver() { 
		super("Silver", 3);	
	}
	
	/**
	 * @see dominion.card.TreasureCard#treasureValue()
	 */
	public int treasureValue() {
		return 2;
	}
}
