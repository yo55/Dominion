# Dominion

Projet de programmation objet en Java - DUT Informatique année spéciale 2017-2018 - IUT de Montpellier


## Prépartion d'une partie

1. Chaque joueur reçoit 7 cartes cuivre et 3 cartes domaine. Ces 10 cartes forment le deck de départ du joueur
Il prend 5 cartes parmis ces 10 pour consistuer sa main.

2. La réserve est consistuée des cartes suivantes. Elles sont placées par type, face visible a portée de tous les joueurs :
- Les cartes Trésor qui comprennent les cartes Cuivre non utilisées et les cartes Argent et Or.
- Les cartes Victoire (Domaine Duché et Province) au nombre de 12 (3-4 joueurs) et 8 (2 joueurs) par type.
- Les cartes Malédiction au nombre de 10 (2 joueurs), 20 (3 joueurs) et 30 (4 joueurs).
- Les cartes Royaume au nombre de 10 doivent être choisies. Pour commencer on propose les cartes suivantes : 
Atelier Bucheron Cave Douves Forgeron Marché Milice Mine Renovation Village.

3. Dans la cas de la carte Royaume Jardins, si elle est choisie parmis les 10 cartes Royaume, un tas de cartes Victoire Jardin égal en nombre aux deux autres piles Victoire doit être placé à côté


## Déroulement d'une partie

Chaque tour est constitué de 3 phases : 

1. Action : Le joueur peut jouer une carte Action s'il en possède une. Il doit effectuer les actions proposées par la carte Action qu'il joue.

2. Achat : Le joueur peut acheter une carte de la réserve en payant son coût avec des cartes Trésor. Par défaut, on ne peut acheter qu'une carte par tour. La carte achetée ne peut être utilisée pour ce tour.

3. Ajustement : Toutes les cartes jouées ou achetées doivent être placées dans la défausse du joueur, une pile dont seule la carte du dessus est visible. Le joueur pioche ensuite 5 autres cartes de son deck pour former sa nouvelle main. Si le deck ne contient pas assez de carte, il doit le mélanger avec la défausse pour piocher sa nouvelle main.

La fin d'une partie intervient lorsque :

- La pile des cartes Province dans la réserve est vie.
- 3 piles de la réserve sont vides.

Les joueurs comptent alors les points victoires sur leur cartes en main, dans leur deck et défausse. Le joueur qui a le plus de points victoire gagne la partie. En cas d'égalité, le joueur qui a le moins de tours l'emporte.

 


