/**The current implementation does not allow to remove a card without deleting all the set.
 * 
 */
package gameEngine;

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

import gameEngine.enumerate.*;

/**The Class Card defines the characteristics of a game card, and defines a Deck in which the cards are created.
 * Methods relative to both elements have been implemented.
 * 
 * @author Marquès Ludovic
 * @version 1.0
 */
class Card {
	/**
	 * Stores the overall number of cards.
	 */
	//private static int nTotal = 0;
	/**
	 * Stores the cards of the Deck.
	 */
	private static Map<Integer, Card> Deck = new HashMap<>();
	
	private int idCard;
	private Color color;
	private Shape shape;
	private boolean isFull;
	
	private Card(int idCard, Color color, Shape shape, boolean isFull) {
		//nTotal++;
		//this.idCard=nTotal;
		this.idCard=idCard;
		this.color=color;
		this.shape=shape;
		this.isFull=isFull;
		Deck.put(this.idCard, this);
	}
	
	/**
	 * Returns the overall number of cards in the Deck.
	 * 
	 * @return the number of cards in the Deck
	 */
	public static int getDeckCardNumber() {
		return Deck.size();
	}
	
	/**
	 * Gets the id of a Card instance.
	 * @return int the card id.
	 */
	public int getId() {
		return this.idCard;
	}
	
	/**Returns the three design characteristics of the Card in an array: the color, the shape, and the boolean that show if the shape is filled.
	 * 
	 * @return Object[]
	 */
	public Object[] getCharact() {
		Object[] charactArray = {this.color, this.shape, this.isFull};
		return charactArray;
	}
	
	/**Creates the Card instances and puts them in the Deck.
	 *  
	 */
	public static void createDeck() {
		
		if (Deck.isEmpty()) {
			Color[] colorArray = Color.values(); //Retrieves all the elements of Color enum
			Shape[] shapeArray = Shape.values(); //Retrieves all the elements of Shape enum
			boolean[] isFullArray = {false, true};
			List<Integer> randId = Card.generateRandId(colorArray.length*shapeArray.length*2); //Generates a List of card id in a random order
			int h = 0;
			
			for (int i=0;i<2;i++) {
				for (int j=0;j<colorArray.length;j++) {
					for (int k=0;k<shapeArray.length;k++) {
						Card cardInst = new Card(randId.get(h), colorArray[j],shapeArray[k],isFullArray[i]); //Create a Card instance
						//System.out.println(colorArray[j]+" "+shapeArray[k]+" "+isFullArray[i]);
						Deck.put(cardInst.idCard, cardInst); //Insert each instances created into the Deck
						h++;
					}
				}
			}
		} else {
			System.out.println("Create a new Card could cause some issues. Please don't do this. Remove your change.");
		}
	}
	
	/**Removes all the Card in the Deck.
	 * 
	 */
	public static void removeDeck() {
		Deck.clear();
	}
	
	public static int drawCard() {
		Set<Integer> idSet = Deck.keySet();
		Iterator<Integer> itId = idSet.iterator();
		int idCard;
		if (itId.hasNext()) {
			idCard = itId.next();
			Deck.remove(idCard);
			return idCard;
		} else {
			return 0;
		}
	}
	
	public static List<Integer> generateRandId(int numbreId) {
		List<Integer> idList = new ArrayList<>();
		for (int i=1;i<=numbreId;i++) {
			idList.add(i);
		}
		Collections.shuffle(idList);
		return idList;
	}
	
	/**
	 * The main method.
	 * @param args
	 */
	public static void main(String[] args) {
		/*Card Card2 = new Card(Color.RED,Shape.CIRCLE,true);
		System.out.println("ID: "+Card2.getId());
		System.out.println("Color: "+Card2.color);
		Object[] CharactArray = Card2.getCharact();
		System.out.println("Shape: "+CharactArray[1]);
		System.out.println("Charact.: "+Arrays.toString(CharactArray));*/
		
		/*System.out.println("Number of cards in the Deck: "+Card.getDeckCardNumber());
		Card.createCardSet();
		System.out.println("Number of cards in the Deck: "+Card.getDeckCardNumber());
		Card cObj = Deck.get(1);
		Object[] charactObj = cObj.getCharact();
		System.out.println(Arrays.toString(charactObj));
		System.out.println(Deck.entrySet());
		
		System.out.println(Deck.keySet());*/
		//System.out.println(Math.floor(Math.random()*2));
		
		Card.createDeck();
		
	}
	
}

