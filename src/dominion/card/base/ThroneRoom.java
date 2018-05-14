package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {

	public ThroneRoom() {
		super("Throne Room", 4);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		String carte = p.chooseCard("THRONE ROOM: Choisissez l'une de vos cartes action: ", p.getActionCards(), false);
		p.playCard(carte);
		

		// jouer une 2e fois la même carte sans la remettre en jeu.
		Card carteAction = p.getInPlayCards().getCard(carte);
		carteAction.play(p);
	}
	
}