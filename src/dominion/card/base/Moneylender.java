package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
import dominion.card.common.Copper;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	
	/**
	 * Constructeur cartes Prêteur sur gages
	 */
	public Moneylender() {
		super("Moneylender", 4);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */	
	public void play(Player p) {
		boolean hasCopper = false;
		for(Card c : p.getTreasureCards()) {
			if (c.getClass().equals(Copper.class)) {
				// on a une carte cuivre
				p.trashCard(c);
				hasCopper = true;
				break;
			}
		}
		if(hasCopper) {
			p.incrementMoney(3);
		}
	}
}