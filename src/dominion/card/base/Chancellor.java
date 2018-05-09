package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {

	/**
	 * Constructeur
	 */
	public Chancellor() {
		super("Chancellor", 3);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {

		// + 2 pièces
		p.incrementMoney(2);

		// option de défausser le deck
		List<String> options = Arrays.asList("Y", "y", "n", "N");

		String choix = p.choose("CHANCELLOR : Défausser le deck ? (y/N) : ", options , true);
		
		if(choix.contains("Y") || choix.contains("y")) {
			p.discardDeck();
		}
	}
}

