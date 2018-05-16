package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {
	/**
	 * Constructeur cartes Espion
	 */

	public Spy() {
		super("Spy", 4);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {

		// le joueur dévoile la première carte de son deck
		Card carteDevoilee = p.drawCard();

		String choix = p.choose("SPY ("+p.getName()+"): Voulez-vous défausser la carte "+carteDevoilee.getName()+ " ? (y/N):", Arrays.asList("y", "Y", "n", "N"), true);
		if(choix.equals("y") || choix.equals("Y")) {
			// on defausse
			p.gain(carteDevoilee);
		}else {
			// on remet sur le deck
			p.addToDeck(carteDevoilee);
		}
		
		// attaque des adversaires
		super.play(p);
	}

	@Override
	/**
	 * @see dominion.card.AttackCard#attack(dominion.Player, dominion.Player)
	 */
	public void attack(Player attacker, Player adv) {

		// le joueur dévoile la première carte de son deck
		Card carteDevoilee = adv.drawCard();

		String choix = adv.choose("SPY ("+attacker.getName()+"): Voulez-vous défausser la carte "+carteDevoilee.getName()+ " ? (y/N):", Arrays.asList("y", "Y", "n", "N"), true);
		if(choix.equals("y") || choix.equals("Y")) {
			// on defausse
			adv.gain(carteDevoilee);
		}else {
			// on remet sur le deck
			adv.addToDeck(carteDevoilee);
		}
	}

	@Override
	/**
	 * @see dominion.card.AttackCard#selfGain(dominion.Player)
	 */
	public void selfGain(Player p) {
		// + 1 carte
		p.addToHand(p.drawCard());

		// + 1 action
		p.incrementActions(1);
	}
}