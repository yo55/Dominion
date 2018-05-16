package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {
	
	/**
	 * Constructeur cartes Aventurier
	 */
	public Adventurer() {
		super("Adventurer", 6);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		int countTreasure = 0;
		CardList stack = new CardList();
		
		// 
		while(countTreasure < 2) {
			Card carteTire = p.drawCard();
			
			// si on a tiré une carte trésor
			if(carteTire instanceof TreasureCard) {
				countTreasure += 1;
				// ajout à la main
				p.addToHand(carteTire);
				
			}else{
				// stockage
				stack.add(carteTire);
			}
		}
		// ajout des cartes stockées à la défausse
		for(Card c : stack) {
			p.gain(c);
		}
		
	}
	
}