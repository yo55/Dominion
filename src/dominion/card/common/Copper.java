package dominion.card.common;
import dominion.card.*;

/**
 * Carte Cuivre (Copper)
 * 
 * 1 Pièce
 */
public class Copper extends TreasureCard {
	/**
	 * Constructeur
	 */
	public Copper() { 
		super("Copper", 0);	
	}
	
	/**
	 * @see dominion.card.TreasureCard#treasureValue()
	 */
	public int treasureValue() {
		return 1;
	}
}
