package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Action
 */
public abstract class ActionCard extends Card {

	/** 
	 * Constructeur cartes d'action
	 * @param name nom de la carte
	 * @param cost cout de la carte
	 */
	public ActionCard(String name, int cost) {
		super(name, cost);
	}
	
	
}