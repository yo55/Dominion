package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Village
 * 
 * +1 Carte.
 * +2 Actions.
 */
public class Village extends ActionCard {
	
	/**
	 * Constructeur cartes village
	 */
	public Village() {
		super("Village", 3);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		// + 1 carte
		p.addToHand(p.drawCard());
		
		// + 2 actions
		p.incrementActions(2);
	}
	
	
}