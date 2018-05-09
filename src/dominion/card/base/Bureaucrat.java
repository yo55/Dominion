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

	public Bureaucrat() {
		super("Bureaucrat",4);		
	}

	@Override
	public void play(Player p) {	
		
		List<Player> otherP=p.getGame().otherPlayers(p);
		p.gain("Silver");
		Player pother;
		for(int i=0;i<otherP.size();i++){
			pother=otherP.get(i);
			if(pother.VictoryCard()){
				pother.cardsInHand();
			}
			else{
				pother
			}
		}
		// TODO Auto-generated method stub
		
	}
}