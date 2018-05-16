package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Forgeron (Smithy)
 * 
 * +3 Cartes.
 */
public class Smithy extends ActionCard {
	
	/**
	 * Constructeur cartes Forgeron
	 */
	public Smithy() {
		super("Smithy", 4);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {

		// pioche de 3 cartes
		for(int i=0; i<3; i++) {
			p.addToHand(p.drawCard());
		}
	}
}