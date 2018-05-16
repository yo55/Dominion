package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Laboratoire (Laboratory)
 * 
 * +2 Cartes.
 * +1 Action.
 */
public class Laboratory extends ActionCard {

	/**
	 * Constructeur cartes Laboratoire
	 */

	public Laboratory() {
		super("Laboratory", 5);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		p.incrementActions(1);
		p.addToHand(p.drawCard());
		p.addToHand(p.drawCard());
	}
	
}