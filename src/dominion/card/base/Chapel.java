package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {
	
	/**
	 * Constructeur cartes Chapelle
	 */
	public Chapel() {
		super("Chapel", 2);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
				
		String carteEcartee;
		
		// Choisir jusqu'à 4 cartes à écarter
		for(int i=0; i<4; i++) {
			carteEcartee = p.chooseCard("CHAPEL: Choisissez une carte à écarter :", p.cardsInHand(), true);
			if(!carteEcartee.isEmpty()) {
				p.trashCard(carteEcartee);
			}else {
				break;
			}
		}
		
	}
}