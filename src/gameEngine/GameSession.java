/**
 * Regarder singleton, TD LO02
 */
package gameEngine;

import gameEngine.enumerate.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**The Class GameSession is used to instantiate a game session.
 * 
 * @author ludov
 */
public class GameSession {
	
	private int i=1;
	private int nbPhysicalPlayer;
	private int nbVirtalPlayer;
    private int nbPlayer;
    private Integer[] cardPosition = new Integer[2];
    private String nameOfPlayer;
	private List<Player> players;
	private Deck deck;
	private GameBoard gBoard;
	private GameMode gMode;
	private NumOfPlayers nP;
	private boolean isOnGoing = false;
	private Map<Card, Integer[]> mapCard;
	private Map<Card, Integer[]> mapCards = new HashMap<Card, Integer[]>();
	Scanner scanner = new Scanner(System.in);
	
	
	public GameSession(GameBoard gBoard, GameMode gMode, NumOfPlayers nP, int nbPhysicalPlayer, int nbVirtalPlayer, int nbPlayer) {
		this.players = new ArrayList<>();
		this.deck = new Deck(); //Creates an unshuffled deck of card
		deck.shuffle(); //Shuffles the deck
		this.gBoard = gBoard; //GameBoard chosen
		this.gMode = gMode; //GameMode chosen
		this.nP = nP; //Number of players
		this.isOnGoing = true;
	    this.nbPhysicalPlayer = nbPhysicalPlayer;
	    this.nbVirtalPlayer = nbVirtalPlayer;
	    this.nbPlayer = nbPlayer;
		nbPhysicalPlayer = nbPlayer - nbVirtalPlayer;
		
		while(nbPhysicalPlayer != 0) {
			System.out.println("Nom du joueur physique n°"+(nbPhysicalPlayer - (nbPhysicalPlayer - i))+" ?");
			nameOfPlayer = scanner.next();
			this.addPhysicalPlayer(nameOfPlayer);
		    nbPhysicalPlayer -= 1;
		    i +=1;
		}
		i=1;
		while (nbVirtalPlayer != 0) {
			System.out.println("Nom du joueur virtuel n°"+(nbVirtalPlayer - (nbVirtalPlayer - i))+" ?");
			nameOfPlayer = scanner.next();
			this.addVirtualPlayer(nameOfPlayer);
		    nbVirtalPlayer -= 1;
		    i +=1;
		}
		
		switch(gMode) {
		
		case ADVANCED:
			//Write code
			break;
			
		case DRAWING:
			//Write code
			break;
		
		case DEFAULT:
			//Write code
			break;
		} //No default coverage, because gMode is necessary an enumeration of GameMode
		
		switch(nP) {
		
		case TWO:
			//Write code
			break;
			
		case THREE:
			//Write code
			break;
		}
		
		while (!deck.isEmpty()) {
		
			this.playRound(scanner, mapCard);
			
		}
		
	} 
	
	public void addVirtualPlayer(String name) {
		players.add(new VirtualPlayer(name));
	}
	
	public void addPhysicalPlayer(String name) {
		players.add(new PhysicalPlayer(name));
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	/*public void changeGameBoard() {
		//A implémenter
	}*/
	
	public void playRound(Scanner scanner, Map<Card, Integer[]> mapCard) {
		Iterator<Player> it = players.iterator();
		while (it.hasNext()) {
			System.out.println(this.gBoard);
			Card drawedCard = deck.drawTopCard();
			System.out.println("Votre carte : "+drawedCard);
			mapCards = it.next().play(drawedCard, mapCard, scanner, this.gBoard);
			
			if (mapCards != null) {
				
				cardPosition[0] = mapCards.get(drawedCard)[0];
				cardPosition[1] = mapCards.get(drawedCard)[1];
			
				//System.out.println("position 0 : "+mapCards.get(drawedCard)[0]+" position 1 : "+mapCards.get(drawedCard)[1]);
				
				try {
					this.gBoard.putDownCard(cardPosition, drawedCard);
				} catch(IndexOutOfBoundsException e) {
					System.err.print("Carte placé en dehors des limites du jeu");
				}
			}
		}
	}
	
	public boolean isFinished() {
		//Si chaque joueur n'a plus de carte dans la main
		//Créer un emplacement victoryCard et hiddenCard --> FAIT, faire les méthodes
		return false;
	}
	
	/** The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
	}
}
