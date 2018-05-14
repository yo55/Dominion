package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Attaque
 * Rmq: les cartes Attaque sont toutes des cartes Action
 */
public abstract class AttackCard extends ActionCard {

	public AttackCard(String name, int cost) {
		super(name, cost);
	}

	/**
	 * Auteur : Yoann
	 * 
	 * Méthode qui porte l'attaque sur le joueur adv
	 * @param attacker le joueur attaquant
	 * @param adv le joueur qui subit l'attaque
	 */
	public abstract void attack(Player attacker, Player adv);
	
	
	/**
	 * Auteur  : Yoann
	 * 
	 * Méthode qui execute les actions nécessaire sur le joueur
	 * qui porte l'attaque.
	 * @param p le joueur attaquant
	 */
	public abstract void selfGain(Player p);

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		// Actions pour le joueur qui attaque
		selfGain(p);
		
		// pour chaque adversaire
		for(Player adv : p.otherPlayers()) {
			if(adv.hasReactionCards()) {
				StringBuilder instr = new StringBuilder();
				instr.append("Vous êtes attaqué par ");
				instr.append(p.getName());
				instr.append(". Voulez-vous révéler Moat (Y/n) ? ");
				String choix = adv.choose(instr.toString(), Arrays.asList("y", "Y", "n", "N"), true );
				if(choix.equals("n") || choix.equals("N")) {
					// l'attaque est portée sur l'adversaire non protégé
					attack(p, adv);
				}
			}else {
				attack(p, adv);
			}
		}
	}
}