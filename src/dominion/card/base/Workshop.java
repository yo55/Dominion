package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {
	/**
	 * Constructeur cartes Atelier
	 */

	public Workshop() {
		super("Workshop", 3);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		CardList cartesPossibles = new CardList();
		
		for(Card c : p.getGame().availableSupplyCards()) {
			if(c.getCost() <= 4) {
				cartesPossibles.add(c);
			}
		}
		p.gain(p.chooseCard("WORKSHOP: Choisir une carte de coût <= 4 :", cartesPossibles, false));
	}
	
}