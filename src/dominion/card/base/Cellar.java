package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {
	
	/**
	 * Constructeur cartes Cave
	 */
	public Cellar() {
		super("Cellar", 2);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		// + 1 action
		p.incrementActions(1);
		
		// defausse de cartes
		String carte = "0";
		while(!carte.isEmpty()) {
			
			// carte à défausser dans la main
			carte = p.chooseCard("CELLAR: Choisissez une carte à défausser ", p.cardsInHand(), true);
			
			// defausse de la carte
			p.discardCard(carte);
			
			// pioche d'une nouvelle carte
			p.addToHand(p.drawCard());
		}
	}
}
	