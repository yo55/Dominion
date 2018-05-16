package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festival
 * 
 * +2 Actions.
 * +1 Achat.
 * +2 Pièces.
 */
public class Festival extends ActionCard {

	/**
	 * Constructeur cartes festival
	 */
	public Festival() {
		super("Festival", 5);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		p.incrementActions(2);
		p.incrementBuys(1);
		p.incrementMoney(2);
	}
}