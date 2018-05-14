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
	 * @see dominion.card.AttackCard#attack(dominion.Player)
	 */
	public void attack(Player attacker, Player adv) {
		while(adv.cardsInHand().size() > 3) {
			String carte = adv.chooseCard("MILITIA (Attack): Choisir une carte à défausser : ", adv.cardsInHand(), false);
			adv.discardCard(carte);
		}		
	}
	
	@Override
	/**
	 * @see dominion.card.AttackCard#selfGain(dominion.Player)
	 */
	public void selfGain(Player p) {
		// + 2 pièces
		p.incrementMoney(2);		
	}

}