package dominion.card;
import dominion.*;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {

	/** 
	 * Constructeur cartes malédiction
	 * @param string nom de la carte
	 * @param i cout de la carte
	 */
	public CurseCard(String string, int i) {
		super(string, i);
	}
	/**
	 * Les cartes malédiction enlèvent 1 point au total des points victoire
	 * @return -1 point victoire
	 */
	public abstract int victoryValue(Player p);
		
}