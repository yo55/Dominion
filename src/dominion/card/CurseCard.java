package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {

	/**
	 * Constructeur cartes malédiction
	 */
	public CurseCard(String string, int i) {
		super("Curse", 0);
	}
	/**
	 * Les cartes malédiction enlèvent 1 point au total des points victoire
	 * @return -1 point victoire
	 */
	public int victoryValue(Player p) {
		return -1;
	}
}