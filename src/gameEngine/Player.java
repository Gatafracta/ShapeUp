/**
 * 
 */
package gameEngine;

import java.util.*;

/**
 * @author Marquès Ludovic
 * @version 1.0
 */
public abstract class Player {
	
	private String name;
	protected Set<Card> hand;
	protected Card victoryCard; //A VOIR
	protected int score;
	
	Player(String name) {
		this.name = name;
		this.hand = new HashSet<Card>();
		this.score = 0;
	}
	
	/**
	 * Allows the player to play.
	 */
	public abstract Map<Card, Integer[]> play(Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner);
		
	/**
	 * Allows the player to take the card in parameter.
	 * @param card the card to put in the hand of the player
	 */
	public void takeCard(Card card) {
		hand.add(card);
	}
	/**
	 * Removes the card from the player's hand and give it.
	 * @param card the card to give
	 * @return Card the given card
	 */
	public Card giveCard(Card card) {
		Card gvCard = card;
		hand.remove(card);
		return gvCard;
	}
	
	/**
	 * Sets the victory card.
	 * @param victoryCard
	 */
	public void setVictoryCard(Card victoryCard) {
		this.victoryCard = victoryCard;
	}
	
	/**
	 * Returns the player's name.
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Prints the hand of the player.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.name+"'s hand:\n");
		sb.append('[');
		Iterator<Card> it = hand.iterator();
		for (int k=0;k<hand.size();k++) {
			sb.append(((Card) it.next()).toString());
		}
		sb.append(']');
		return sb.toString();
	}
	
	/** The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TEST toString Method
		Player p1 = new VirtualPlayer("Jamy"); //Crée le joueur Jamy
		System.out.println(p1.toString());
		
	}

}
