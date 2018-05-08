package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Trésor
 */
public abstract class TreasureCard extends Card {
	
	/**
	 * Constructeur cartes trésor
	 * @param name nom de la carte 
	 * @param cost coût de la carte
	 */
	public TreasureCard(String name, int cost) {
		super(name, cost);
	}
	
	/**
	 * Retourne la valeur d'une carte trésor
	 * @return valeur de la carte
	 */
	public abstract int treasureValue();
	
	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		p.incrementMoney(this.treasureValue());
	}
}