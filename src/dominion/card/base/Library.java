package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {

	/**
	 * Constructeur cartes bibliothèque
	 */
	public Library() {
		super("Library", 5);
	}

	public void play(Player p) {
		CardList aCote = new CardList();

		while(p.cardsInHand().size() < 7) {
			// pioche d'une carte
			Card carteTire = p.drawCard();

			// si c'est une carte action
			if(carteTire instanceof ActionCard) {
				List<String> choices = Arrays.asList("y", "Y", "n", "N");
				String choice = p.choose("LIBRARY: Défausser la carte tirée "+carteTire.getName().toUpperCase() + " ? (y/N): ", choices, true);

				// si le joueur choisi de garder la carte
				if(choice.contains("N") || choice.contains("n") || choice.isEmpty()) {
					// on l'ajoute à sa main
					p.addToHand(carteTire);
				}else {
					// sinon on l'ajoute à la pile d'à côté
					aCote.add(carteTire);
				}
			}else {
				// on ajoute les autres cartes tirées à la main
				p.addToHand(carteTire);
			}
		}
		// on met à la défausse les cartes mises de côté
		for(Card c : aCote) {
			p.gain(c);
		}
	}
}