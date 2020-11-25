/**
 * 
 */
package gameEngine;

import exceptions.*;
import gameEngine.enumerate.*;
//import java.util.List;
//import java.util.LinkedList;
//import java.util.Collections;
import java.util.*; //More convenient during development

/**The Class Deck defines the characteristics of a deck and provides some methods relating to it.
 * 
 * @author Marquès Ludovic
 * @version 2.0
 */
class Deck {
	
	/**
	 * The number of cards created at instantiation.
	 */
	public final static int NUM_OF_CARDS = Color.values().length*Shape.values().length*2;
	
	/**
	 * Stores the card components of the Deck.
	 */
	private List<Card> components;
	
	/**
	 * The hidden card if there is one.
	 */
	private Card hiddenCard = null;
	
	/**
	 * Creates an unshuffled deck of cards.
	 */
	Deck() {
		this.components = new LinkedList<>();
		
		try {
			Card.createDeckComp((LinkedList<Card>) components); //Create the components of the deck
		} catch(DeckAlreadyUsedException e) {
			//The list "components" is necessary empty. All we have to do is do nothing to catch the exception.
		}
		//System.out.println("components.size(): "+components.size());
	}
	
	/**
	 * Returns true if the deck is empty, otherwise returns false.
	 * @return boolean
	 */
	public boolean isEmpty() {
		return components.isEmpty();
	}
	
	/**
	 * Shuffles the card components from the deck.
	 */
	public void shuffle() {
		Collections.shuffle(components);
	}
	
	/**
	 * Removes and returns the top card of the deck.
	 * @return Card the top card of the deck
	 */
	public Card drawTopCard() {
		return (Card) ((LinkedList<Card>) components).pop();
	}
	
	/**
	 * Removes and returns a random card from the deck.
	 * @return Card a random card from the deck
	 */
	public Card drawRandomCard() {
		int randPos = (int) Math.round(Math.random()*(Deck.NUM_OF_CARDS-1));
		return (Card) ((LinkedList<Card>) components).remove(randPos);
	}
	
	/**
	 * Defines a hidden card.
	 * @param hiddenCard the hidden card
	 * @throws hiddenCardAlreadySettledException
	 */
	public void setHiddenCard(Card hiddenCard) throws hiddenCardAlreadySettledException {
		if (this.hiddenCard==null) {
			this.hiddenCard=hiddenCard;
		} else {
			throw new hiddenCardAlreadySettledException("The hidden card has already been settle.");
		}
	}
	
	/**
	 * Returns the hidden card.
	 * @return Card the hidden card.
	 */
	/*public Card getHiddenCard() {
		return hiddenCard;
	}*/ //Inutile à priori
	
	/**
	 * Displays the deck in the console.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Deck's card:\n[");
		Iterator<Card> it = this.components.iterator();
		for (int k=0;k<this.components.size()-1;k++) {
			sb.append(it.next().toString());
			sb.append(", ");
		}
		if (it.hasNext()) {
			sb.append(it.next().toString()); //In the case of an empty deck
		}
		sb.append(']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println(deck.toString());
		try {
			deck.setHiddenCard(deck.drawRandomCard());
		} catch (hiddenCardAlreadySettledException e) {
			e.printStackTrace();
		}
		System.out.println(deck.toString());
		//System.out.println(deck.getHiddenCard());
	}

}
