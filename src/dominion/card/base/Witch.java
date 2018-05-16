package dominion.card.base;
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
	 * @see dominion.card.AttackCard#attack(dominion.Player, dominion.Player)
	 */
	public void attack(Player attacker, Player adv) {
		// l'adversaire prend une carte malédiction
		adv.gain("Curse");
	}

	@Override
	/**
	 * @see dominion.card.AttackCard#selfGain(dominion.Player)
	 */
	public void selfGain(Player p) {
		// + 2 cartes
		for(int i=0; i<2; i++) {
			p.addToHand(p.drawCard());
		}		
	}

}