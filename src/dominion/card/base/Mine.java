package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	
	/**
	 * Constructeur cartes mines
	 */
	public Mine() {
		super("Mine", 5);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		// carte à écarter
		String trashCard = p.chooseCard("MINE: Choisissez une carte trésor à écarter :", p.getTreasureCards(), false);
		Card carteEcarte = p.trashCard(trashCard);
		
		// ensemble des cartes trésor disponibles
		CardList availableTreasureCards = new CardList();
		for(Card card : p.getGame().availableSupplyCards()) {
			if(card instanceof TreasureCard) {
				if(card.getCost() <= carteEcarte.getCost() + 3) {
					availableTreasureCards.add(card);
				}
			}
		}
		
		// carte à recevoir et placer dans sa main
		String chosenCard = p.chooseCard("MINE: Choisissez une carte trésor (prix max "+(3+carteEcarte.getCost()) + "): ", availableTreasureCards, false);
		p.addToHand(p.getGame().getFromSupply(chosenCard));
		
	}
}