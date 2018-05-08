package dominion.card.common;
import dominion.card.*;

/**
 * Carte Or (Gold)
 * 
 * 3 Pièces
 */
public class Gold extends TreasureCard {
	
	/**
	 * Constructeur
	 */
	public Gold() {
		super("Gold", 6);	
	}
	
	/**
	 * @see dominion.card.TreasureCard#treasureValue()
	 */
	public int treasureValue() {
		return 3;
	}
}
