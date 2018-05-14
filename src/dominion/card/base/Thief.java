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
	 * @see dominion.card.AttackCard#play(dominion.Player)
	 */
	public void play(Player p) {
		
		CardList cartesEcartees = new CardList();

		// On vole chaque adversaire
		for(Player adv : p.otherPlayers()) {
			Card carte = thiefAttack(p, adv);
			if (carte != null) {
				cartesEcartees.add(carte);
			}
		}
		// On choisit parmi les cartes récupérées
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

	/**
	 * Attaque spéciale du Voleur.
	 * Retourne la carte trésor de l'adversaire choisie par l'attaquant 
	 * @param attacker le joueur attaquant
	 * @param adv le joueur attaqué
	 * @return la carte trésor choisie ou null si aucune carte n'a été choisie
	 */
	public Card thiefAttack(Player attacker, Player adv) {
				
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
			String choix = attacker.chooseCard("THIEF: "
					+ adv.getName()
					+ " dévoile [ "
					+ cartesTresorDevoilees.toString() 
					+ " ]. Choississez une carte à écarter: ", cartesTresorDevoilees, false);
			
			Card carteChoisie = null;
			for(Card carte : cartesTresorDevoilees) {
				if(carte.getName().equals(choix)) {
					carteChoisie = carte;
				}else {
					// l'autre carte est défaussée
					adv.gain(carte);
				}
			}
			return carteChoisie;
		}
		
		

	@Override
	/**
	 * @see dominion.card.AttackCard#selfGain(dominion.Player)
	 */
	public void selfGain(Player p) {
		// rien à faire
	}

	@Override
	/**
	 * @see dominion.card.AttackCard#attack(dominion.Player, dominion.Player)
	 */
	public void attack(Player attacker, Player adv) {
		// inutilisable avec la redéfinition de AttackCard.play()
	}
}