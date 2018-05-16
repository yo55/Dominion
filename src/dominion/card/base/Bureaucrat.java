package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck 
 * (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {

	/**
	 * Constructeur cartes bureaucrates
	 */
	public Bureaucrat() {
		super("Bureaucrat",4);		
	}

	
	@Override
	/**
	 * @see dominion.card.AttackCard#attack(dominion.Player, dominion.Player)
	 */
	public void attack(Player attacker, Player adv) {
		// on lui fait choisir quell carte Victoire il veut placer sur son deck
		String choix = adv.chooseCard("BUREAUCRAT ("+attacker.getName()+"): Quelle carte Victoire voulez-vous révéler ? : ", adv.getVictoryCards(), false);
		if(!choix.isEmpty()) {
			// déplacement de la main vers le deck
			adv.addToDeck(choix);
		}else {
			// l'adversaire n'a aucune carte Victoire dans sa main - Il la dévoile 
			System.out.println("BUREAUCRAT: Main de "
					+adv.getName()+": "
					+adv.getActionCards().toString()
					+" " +adv.getVictoryCards().toString()
				);
		}
	}

	@Override
	/**
	 * @see dominion.card.AttackCard#selfGain(dominion.Player)
	 */
	public void selfGain(Player p) {
		// gagne une carte argent
		p.addToDeckFromSupply("Silver");

	}
}