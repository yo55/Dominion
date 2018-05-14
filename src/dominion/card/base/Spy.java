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

	public Spy() {
		super("Spy", 4);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		// + 1 carte
		p.addToHand(p.drawCard());
		
		// + 1 action
		p.incrementActions(1);
		
		
		List<Player> fullHouse = p.otherPlayers();
		fullHouse.add(0,p);
		
		for(Player joueur : fullHouse) {
			// le joueur dévoile la première carte de son deck
			Card carteDevoilee = joueur.drawCard();
			
			String choix = joueur.choose("SPY ("+p.getName()+"): Voulez-vous défausser la carte "+carteDevoilee.getName()+ " ? (y/N):", Arrays.asList("y", "Y", "n", "N"), true);
			if(choix.equals("y") || choix.equals("Y")) {
				// on defausse
				joueur.gain(carteDevoilee);
			}else {
				// on remet sur le deck
				joueur.addToDeck(carteDevoilee);
			}

			
		}
	}
}