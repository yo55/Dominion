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
		ArrayList<String> cartes = new ArrayList<>();
		String carte = "0";
		
		// choix des cartes à défausser
		while(!carte.isEmpty()) {
			carte = p.chooseCard("CELLAR: Choisissez une carte à défausser ", p.cardsInHand(), true);
			if(!carte.isEmpty()) {
				cartes.add(carte);
			}
		}
		
		// defausse des cartes choisies
		for(String c : cartes) {
			p.discardCard(c);
		}
		
		// pioche de nouvelles cartes
		for(int i=0; i<cartes.size(); i++) {
			p.addToHand(p.drawCard());
		}
	}
}
	