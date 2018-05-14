package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {
	
	/**
	 * Constructeur cartes sorcières
	 */
	public Witch() {
		super("Witch", 5);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		// + 2 cartes
		for(int i=0; i<2; i++) {
			p.addToHand(p.drawCard());
		}
		
		// Chaque adversaire prend une carte malédiction
		for(Player adv : p.otherPlayers()) {
			adv.gain("Curse");
		}
	
	}
	
}