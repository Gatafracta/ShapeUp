/**The current implementation does not allow to remove a card without deleting all the set.
 * See nTotal in the code to understand.
 * 
 * --> Use HashMap will solve this issue.
 */
package gameEngine;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

import gameEngine.enumerate.*;

/**The Class Card defines the characteristics and behaviors of a game card.
 * @author Marquès Ludovic
 *
 */
class Card {
	/**
	 * Stores the overall number of cards.
	 */
	private static int nTotal = 0;
	private static Map<Integer, Card> Deck = new HashMap<>();
	
	//private int idCard;
	public Color color; //to be discussed in regard to enumerate
	public Shape shape; //same
	public boolean isFull; //same
	
	public Card(Color color, Shape shape, boolean isFull) {
		this.color=color;
		this.shape=shape;
		this.isFull=isFull;
		//this.idCard=nTotal+1;
		Deck.put(nTotal+1, this);
		nTotal++;
		System.out.println(Deck.get(nTotal)); //To continue, very interesting
	}
	
	/**
	 * Returns the overall number of cards.
	 */
	public int getCardNumber() {
		return nTotal;
	}
	
	public Object[] getCharact() {
		Object[] charactArray = {this.color, this.shape, this.isFull};
		return charactArray;
	}
	
	/*
	public int getId() {
		return this.idCard;
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card Card2 = new Card(Color.RED,Shape.CIRCLE,true);
		//System.out.println("ID: "+Card2.getId());
		System.out.println("Color: "+Card2.color);
		Object[] CharactArray = Card2.getCharact();
		System.out.println("Shape: "+CharactArray[1]);
		System.out.println("Charact.: "+Arrays.toString(CharactArray));
	}
	
}

