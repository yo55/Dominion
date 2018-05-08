package dominion.card.base;

import dominion.*;
import dominion.card.*;

/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {

	/**
	 * Constructeur cartes Rénovation
	 */
	public Remodel() {
		super("Remodel", 4);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		// choix de la carte à écarter
		String carteAEcarter = p.chooseCard("REMODEL: Choissir carte à écarter : ", p.cardsInHand(), false);
		int cout = p.cardsInHand().getCard(carteAEcarter).getCost();
		p.trashCard(carteAEcarter);
		
		// Carte à recevoir
		CardList cartesPossibles = new CardList();
		for(Card carte : p.getGame().availableSupplyCards()) {
			if(carte.getCost() <= cout + 2) {
				cartesPossibles.add(carte);
			}
		}
		p.gain(p.chooseCard("REMODEL: Choisir une carte à gagner :", cartesPossibles, false));
	}
}