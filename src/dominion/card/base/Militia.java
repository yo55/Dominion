package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {
	
	
	/**
	 * Construteur cartes milice
	 */
	public Militia() {
		super("Militia", 4);
	}
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {

		// + 2 pièces
		p.incrementMoney(2);
		
		// Pour chaque adversaire
		for(Player adv : p.getGame().otherPlayers(p)) {
			
			// tant qu'il a plus de trois cartes
			while(adv.cardsInHand().size() > 3) {
				String carte = adv.chooseCard("MILITIA (Attack): Choisir une carte à défausser : ", adv.cardsInHand(), false);
				adv.discardCard(carte);
			}
			
		}
		
	}

}