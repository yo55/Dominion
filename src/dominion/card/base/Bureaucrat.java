package dominion.card.base;
import java.util.*;

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
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		// gagne une carte argent
		p.addToDeckFromSupply("Silver");

		// Pour chaque adversaire
		for(Player adv : p.getGame().otherPlayers(p)) {
						
			// on lui fait choisir quell carte Victoire il veut placer sur son deck
			String choix = adv.chooseCard("BUREAUCRAT ("+p.getName()+"): Quelle carte Trésor voulez-vous révéler ? : ", adv.getVictoryCards(), false);
			if(!choix.isEmpty()) {
				// déplacement de la main vers le deck
				adv.addToDeck(choix);
			}
		}
	
	}
}