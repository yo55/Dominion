package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chambre du conseil (Council Room)
 * 
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends ActionCard {
	
	/**
	 * Constructeur cartes Chambre du Conseil
	 */
	public CouncilRoom() {
		super("Council Room", 5);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		// + 1 achat
		p.incrementBuys(1);
		
		// +  4 cartes
		for(int i=0; i<4; i++) {
			p.addToHand(p.drawCard());
		}
		
		// Chaque adversaire pioche une carte
		for(Player otherPlayer : p.getGame().otherPlayers(p)) {
			otherPlayer.addToHand(otherPlayer.drawCard());
		}
	}
	
}