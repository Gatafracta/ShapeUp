/**
 * Regarder singleton, TD LO02
 */
package gameEngine;

import gameEngine.enumerate.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**The Class GameSession is used to instantiate a game session.
 * 
 * @author ludov
 */
public class GameSession {
		
	private List<Player> players;
	private Deck deck;
	private GameBoard gBoard;
	private GameMode gMode;
	private NumOfPlayers nP;
	private boolean isOnGoing = false;
	private Map<Card, Integer[]> mapCards;
	Scanner scanner = new Scanner(System.in);
	
	
	public GameSession(GameBoard gBoard, GameMode gMode, NumOfPlayers nP) {
		this.players = new ArrayList<>();
		this.deck = new Deck(); //Creates an unshuffled deck of card
		deck.shuffle(); //Shuffles the deck
		this.gBoard = gBoard; //GameBoard chosen
		this.gMode = gMode; //GameMode chosen
		this.nP = nP; //Number of players
		this.isOnGoing = true;
	   
		
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
			Card drawedCard = deck.drawRandomCard();
			Map<Card, Integer[]> returnedValues = it.next().play(drawedCard, mapCard, scanner, gBoard);
			gBoard.putDownCard(returnedValues.get(drawedCard), drawedCard);
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
