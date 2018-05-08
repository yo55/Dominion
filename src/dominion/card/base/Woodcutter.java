package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bûcheron (Woodcutter)
 * 
 * +1 Achat.
 * +2 Pièces.
 */
public class Woodcutter extends ActionCard {
	
	/**
	 * Constructeur cartes bûcheron
	 */
	public Woodcutter() {
		super("Woodcutter", 3);
	}
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		// +1 achat
		p.incrementBuys(1);
		
		// +2 pièces
		p.incrementMoney(2);
	}
}