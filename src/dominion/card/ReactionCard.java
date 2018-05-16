package dominion.card;


/**
 * Les cartes Réaction
 * Rmq: les cartes Réaction sont toutes des cartes Action
 */
public abstract class ReactionCard extends ActionCard {
	/** 
	 * Constructeur cartes Réaction
	 * @param name nom de la carte
	 * @param cost cout de la carte
	 */

	public ReactionCard(String name, int cost) {
		super(name, cost);		
	}
}