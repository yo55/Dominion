package dominion;
import java.util.*;
import dominion.card.*;
import dominion.card.common.*;

/**
 * Class représentant une partie de Dominion
 */
public class Game {
	/**
	 * Tableau contenant les joueurs de la partie
	 */
	private Player[] players;

	/**
	 * Index du joueur dont c'est actuellement le tour
	 */
	private int currentPlayerIndex;

	/**
	 * Liste des piles dans la réserve du jeu.
	 * 
	 * On suppose ici que toutes les listes contiennent des copies de la même
	 * carte.
	 * Ces piles peuvent être vides en cours de partie si toutes les cartes de 
	 * la pile ont été achetées ou gagnées par les joueurs.
	 */
	private List<CardList> supplyStacks;

	/**
	 * Liste des cartes qui ont été écartées (trash)
	 */
	private CardList trashedCards;

	/**
	 * Scanner permettant de lire les entrées au clavier
	 */
	private Scanner scanner;

	/**
	 * Constructeur
	 * 
	 * @param playerNames liste des noms des joueurs qui participent à la 
	 * partie. Le constructeur doit créer les objets correspondant aux joueurs
	 * @param kingdomStacks liste de piles de réserve à utiliser correspondant 
	 * aux cartes "royaume" à utiliser dans la partie, auxquelles le 
	 * constructeur doit ajouter les piles "communes":
	 * - 60 Copper
	 * - 40 Silver
	 * - 30 Gold
	 * - 8 (si 2 joueurs) ou 12 (si 3 ou 4 joueurs) Estate, Duchy et Province 	 * - 10 * (n-1) Curse où n est le nombre de joueurs dans la partie
	 */
	public Game(String[] playerNames, List<CardList> kingdomStacks) {

		int nbPlayers = playerNames.length;

		// initialisations
		this.currentPlayerIndex = 0;
		this.trashedCards = new CardList();
		this.scanner = new Scanner(System.in);

		// création des joueurs
		this.players = new Player[nbPlayers];
		for(int i=0; i<nbPlayers; i++) {
			this.players[i] = new Player(playerNames[i], this);
		}


		// création de la réserve
		this.supplyStacks = new ArrayList<>();


		// ajout des cartes royaume à la réserve
		this.supplyStacks.addAll(kingdomStacks);

		// ajout pile cartes cuivre
		CardList copperCards = new CardList();
		for(int i =0; i<60-(nbPlayers*7); i++) {
			copperCards.add(new Copper());
		}
		this.supplyStacks.add(copperCards);

		// ajout pile cartes argent
		CardList silverCards = new CardList();
		for(int i =0; i<40; i++) {
			silverCards.add(new Silver());
		}
		this.supplyStacks.add(silverCards);

		// ajout pile cartes or
		CardList goldCards = new CardList();
		for(int i =0; i<30; i++) {
			goldCards.add(new Gold());
		}
		this.supplyStacks.add(goldCards);

		// ajout pile cartes Victoire (Estate, Duchy et Province)
		CardList estateCards = new CardList();
		CardList duchyCards = new CardList();
		CardList provinceCards = new CardList();

		int nbVictoryCards = (nbPlayers <= 2)?8:12;
		for(int i= 0; i<nbVictoryCards; i++) {
			estateCards.add(new Estate());
			duchyCards.add(new Duchy());
			provinceCards.add(new Province());
		}

		this.supplyStacks.add(estateCards);
		this.supplyStacks.add(duchyCards);
		this.supplyStacks.add(provinceCards);


	}

	/**
	 * Renvoie le joueur correspondant à l'indice passé en argument
	 * On suppose {@code index} est un indice valide du tableau 
	 * {@code this.players}
	 * 
	 * @param index indice dans le tableau des joueurs du joueur à renvoyer
	 */
	public Player getPlayer(int index) {
		return this.players[index];
	}

	/**
	 * Renvoie le nombre de joueurs participant à la partie
	 */
	public int numberOfPlayers() {
		return this.players.length;
	}

	/**
	 * Renvoie l'indice du joueur passé en argument dans le tableau des 
	 * joueurs, ou -1 si le joueur n'est pas dans le tableau.
	 */
	private int indexOfPlayer(Player p) {
		for(int i=0; i<players.length; i++) {
			if (players[i] == p) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Renvoie la liste des adversaires du joueur passé en argument, dans 
	 * l'ordre dans lequel ils apparaissent à partir du joueur {@code p}.
	 * 
	 * @param p joueur dont on veut renvoyer la liste des adversaires. On 
	 * suppose que {@code p} est bien dans le tableau des joueurs.
	 * @return un {@code ArrayList} contenant les autres joueurs de la partie 
	 * en commençant par celui qui se trouve juste après {@code p} et en 
	 * terminant par celui qui se trouve juste avant (le tableau est considéré 
	 * comme cyclique c'est-à-dire qu'après le premier élément on revient au 
	 * premier).
	 */
	public List<Player> otherPlayers(Player p) {
		ArrayList<Player> listOthers = new ArrayList<>();

		// index du joueur p
		int playerIndex = indexOfPlayer(p);

		// joueur suivant p
		int nextPlayer = (playerIndex == players.length-1)?0:playerIndex+1;

		//System.out.println("\n player: " + playerIndex + " next: " + nextPlayer);

		// tous les joueurs après p cycliquement
		for(int i=0; i<players.length-1; i++) {
			listOthers.add(players[(i + nextPlayer)%(players.length)]);
		}

		return listOthers;

	}

	/**
	 * Renvoie la liste des cartes qui sont disponibles à l'achat dans la 
	 * réserve.
	 * 
	 * @return une liste de cartes contenant la première carte de chaque pile 
	 * non-vide de la réserve (cartes royaume et cartes communes)
	 */
	public CardList availableSupplyCards() {
		CardList availCards = new CardList();
		for( CardList pile : this.supplyStacks) {
			if(!pile.isEmpty() ) {
				availCards.add(pile.get(0));
			}
		}
		return availCards;
	}

	/**
	 * Renvoie une représentation de l'état de la partie sous forme d'une chaîne
	 * de caractères.
	 * 
	 * Cette représentation comporte
	 * - le nom du joueur dont c'est le tour
	 * - la liste des piles de la réserve en indiquant pour chacune :
	 *   - le nom de la carte
	 *   - le nombre de copies disponibles
	 *   - le prix de la carte
	 *   si la pile n'est pas vide, ou "Empty stack" si la pile est vide
	 */
	public String toString() {
		Player currentPlayer = this.players[this.currentPlayerIndex];
		String r = String.format("     -- %s's Turn --\n", currentPlayer.getName());
		for (List<Card> stack: this.supplyStacks) {
			if (stack.isEmpty()) {
				r += "[Empty stack]   ";
			} else {
				Card c = stack.get(0);
				r += String.format("%s x%d(%d)   ", c.getName(), stack.size(), c.getCost());
			}
		}
		r += "\n";
		return r;
	}

	/**
	 * Renvoie une carte de la réserve dont le nom est passé en argument.
	 * 
	 * @param cardName nom de la carte à trouver dans la réserve
	 * @return la carte trouvée dans la réserve ou {@code null} si aucune carte 
	 * ne correspond
	 */
	public Card getFromSupply(String cardName) {
		for(CardList stack : this.supplyStacks) {
			if (!stack.isEmpty() && stack.get(0).getName().equals(cardName)) {
				return stack.get(0);
			}
		}
		return null;
	}

	/**
	 * Retire et renvoie une carte de la réserve
	 * 
	 * @param cardName nom de la carte à retirer de la réserve
	 * @return la carte retirée de la réserve ou {@code null} si aucune carte
	 * ne correspond au nom passé en argument
	 */
	public Card removeFromSupply(String cardName) {
		for(CardList stack : this.supplyStacks) {
			if (!stack.isEmpty() && stack.get(0).getName().equals(cardName)) {
				return stack.remove(0);
			}
		}
		return null;
	}

	/**
	 * Teste si la partie est terminée
	 * 
	 * @return un booléen indiquant si la partie est terminée, c'est-à-dire si
	 * au moins l'une des deux conditions de fin suivantes est vraie
	 *  - 3 piles ou plus de la réserve sont vides
	 *  - la pile de Provinces de la réserve est vide
	 * (on suppose que toute partie contient une pile de Provinces, et donc si 
	 * aucune des piles non-vides de la réserve n'est une pile de Provinces, 
	 * c'est que la partie est terminée)
	 */
	public boolean isFinished() {

		int emptyStacks=0;
		boolean provinceStackEmpty = true;
		for(CardList stack : this.supplyStacks) {
			if(!stack.isEmpty() && stack.get(0).getName().equals("Province")) {
				provinceStackEmpty = false;
			}else if(stack.isEmpty()) {
				emptyStacks++;
			}
		}
		return (emptyStacks>=3) || provinceStackEmpty;
	}

	/**
	 * Boucle d'exécution d'une partie.
	 * 
	 * Cette méthode exécute les tours des joueurs jusqu'à ce que la partie soit
	 * terminée. Lorsque la partie se termine, la méthode affiche le score 
	 * final et les cartes possédées par chacun des joueurs.
	 */
	public void run() {
		while (! this.isFinished()) {
			// joue le tour du joueur courant
			this.players[this.currentPlayerIndex].playTurn();
			// passe au joueur suivant
			this.currentPlayerIndex += 1;
			if (this.currentPlayerIndex >= this.players.length) {
				this.currentPlayerIndex = 0;
			}
		}
		System.out.println("Game over.");
		// Affiche le score et les cartes de chaque joueur
		for (int i = 0; i < this.players.length; i++) {
			Player p = this.players[i];
			System.out.println(String.format("%s: %d Points.\n%s\n", p.getName(), p.victoryPoints(), p.totalCards().toString()));
		}
	}

	/**
	 * Lit une ligne de l'entrée standard
	 * 
	 * C'est cette méthode qui doit être appelée à chaque fois qu'on veut lire
	 * l'entrée clavier de l'utilisateur (par exemple dans Player.choose), ce
	 * qui permet de n'avoir qu'un seul Scanner pour tout le programme
	 * 
	 * @return une chaîne de caractères correspondant à la ligne suivante de
	 * l'entrée standard (sans le retour à la ligne final)
	 */
	public String readLine() {
		return this.scanner.nextLine();
	}


	public static void main(String[] args) {
		int nbPlayers = 6;

		// création du jeu
		System.out.print("Available players : ");
		String[] myPlayers = new String[nbPlayers];
		for(int i=0; i<nbPlayers; i++) {
			myPlayers[i] = "player "+i;
			System.out.print(myPlayers[i] +  " ");
		}

		Game myGame = new Game(myPlayers, new ArrayList<>());
		System.out.println("\n"+myGame.toString());
		System.out.println("*********");		


		// test fonction otherPlayers
		for(int i=0; i<myPlayers.length; i++) {
			System.out.print("Adversaries of player n° " + i + "  are : ");

			for(Player pl : myGame.otherPlayers(myGame.getPlayer(i))) {
				System.out.print(pl.getName() + " | ");
			}
			System.out.println("");
		}

		System.out.println("*********");

		// test fonction availableSupplyCards()
		System.out.print("Supply cards available at game begining : ");
		for(Card card : myGame.availableSupplyCards()) {
			System.out.print(card.getName() + " | ");
		} 
		System.out.println("");

		myGame.supplyStacks.get(4).clear();
		System.out.print("Supply cards available after removing all Duchy Cards : ");
		for(Card card : myGame.availableSupplyCards()) {
			System.out.print(card.getName() + " | ");
		} 
		System.out.println("\nGame status : " + myGame.toString());

		System.out.println("*********");

		// test fonction get/remove fromSupply()
		System.out.println("getFromSupply(Gold): " + (myGame.getFromSupply("Gold")==null?"null":"not null"));
		System.out.println("getFromSupply(Duchy): " + (myGame.getFromSupply("Duchy")==null?"null":"not null"));
		System.out.println("getFromSupply(Truc): " + (myGame.getFromSupply("Truc")==null?"null":"not null"));

		System.out.println("Removing one Gold Card"); myGame.removeFromSupply("Gold");
		System.out.println("Removing one Estate Card"); myGame.removeFromSupply("Estate");
		System.out.println("Removing one Duchy Card"); myGame.removeFromSupply("Duchy");

		System.out.println("Game status : " + myGame.toString());

		System.out.println("*********");


		// test fonction isFinished()
		myGame = new Game(myPlayers, new ArrayList<>());
		System.out.println("New Game : " + myGame.toString());
		System.out.println("Is the Game finished ? " + (myGame.isFinished()?"yes":"no"));


		myGame.supplyStacks.get(5).clear();
		System.out.println("Clearing Province stack : " + myGame.toString());
		System.out.println("Is the Game finished ? " + (myGame.isFinished()?"yes":"no"));

		myGame = new Game(myPlayers, new ArrayList<>());
		System.out.println("New Game : " + myGame.toString());
		System.out.println("Is the Game finished ? " + (myGame.isFinished()?"yes":"no"));

		myGame.supplyStacks.get(2).clear();
		System.out.println("Clearing one stack : " + myGame.toString());
		System.out.println("Is the Game finished ? " + (myGame.isFinished()?"yes":"no"));
		myGame.supplyStacks.get(3).clear();
		System.out.println("Clearing one stack : " + myGame.toString());
		myGame.supplyStacks.get(4).clear();
		System.out.println("Clearing one stack : " + myGame.toString());
		System.out.println("Is the Game finished ? " + (myGame.isFinished()?"yes":"no"));




	}
}