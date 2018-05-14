package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck. S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. Parmi ces cartes Trésor écartées, recevez celles de votre choix. Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {

	public Thief() {
		super("Thief", 4);
	}

	@Override
	/**
	 * @see dominion.card.Card#play(dominion.Player)
	 */
	public void play(Player p) {
		
		CardList cartesEcartees = new CardList();
		
		for(Player adv : p.otherPlayers()) {
			
			CardList cartesTresorDevoilees = new CardList();
			
			// Les adversaires dévoilent deux cartes de leur deck
			for(int i=0; i<2; i++ ) {
				Card carteTiree = adv.drawCard();
				if(carteTiree instanceof TreasureCard) {
					// ajout aux cartes écartées
					cartesTresorDevoilees.add(carteTiree);
				}else {
					// defausse
					adv.gain(carteTiree);
				}
			}
			
			// Le joueur choisit l'une d'entre elles si il y en a deux, choix automatique sinon
			String choix = p.chooseCard("THIEF: "
					+ adv.getName()
					+ " dévoile [ "
					+ cartesTresorDevoilees.toString() 
					+ " ]. Choississez une carte à écarter: ", cartesTresorDevoilees, false);
			
			for(Card carte : cartesTresorDevoilees) {
				if(carte.getName().equals(choix)) {
					// la carte choisie est écartée
					cartesEcartees.add(carte);
				}else {
					// l'autre carte est défaussée
					adv.gain(carte);
				}
			}
		}
		String choix = "0";
		while(!choix.isEmpty()) {
			choix = p.chooseCard("THIEF: Choisissez des cartes parmi [ "+cartesEcartees.toString()+" ]: ", cartesEcartees, true);
			if(!choix.isEmpty()) {

				// le joueur gagne cette carte
				p.gain(cartesEcartees.getCard(choix));
				
				// on la retire des cartes disponibles
				cartesEcartees.remove(choix);
			}
		}
		
	}
}