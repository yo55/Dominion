package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Écartez cette carte.
 * Recevez une carte coûtant jusqu'à 5 Pièces.
 */
public class Feast extends ActionCard {

	/**
	 * Constructeur cartes Festin
	 */
	public Feast() {
		super("Feast", 4);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {

		// On met la carte au rebus
		p.trashCard(this);

		// On demande à choisir un carte de coût <= 5
		CardList cartesPossibles = new CardList();

		for(Card c : p.getGame().availableSupplyCards()) {
			if(c.getCost() <= 5) {
				cartesPossibles.add(c);
			}
		}
		p.gain(p.chooseCard("FEAST: Choisir une carte de coût <= 5 :", cartesPossibles, false));


	}
}