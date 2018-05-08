package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Domaine (Estate)
 * 
 * 1 VP
 */
public class Estate extends VictoryCard {
	
	/**
	 * Constructeur
	 */
	public Estate() { 
		super("Estate", 2);	
	}
	
	/**
	 * @see dominion.card.VictoryCard#victoryValue(dominion.Player)
	 */
	public int victoryValue(Player p) {
		return 1;
	}
	
}