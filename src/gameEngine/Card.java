/**
 * 
 */
package gameEngine;

import gameEngine.enumerate.*;
import exceptions.*;

import java.util.List;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

/**The Class Card defines the characteristics of a game card and provides some methods relating to them.
 * 
 * @author Marqu�s Ludovic
 * @version 2.0
 */
public class Card {
	
	private int idCard;
	private Color color;
	private Shape shape;
	private boolean isFull;
	
	private Card(int idCard, Color color, Shape shape, boolean isFull) {
		this.idCard=idCard;
		this.color=color;
		this.shape=shape;
		this.isFull=isFull;
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
	 * @return Object[] This Array consists of the color, the shape, and the filling of the Card
	 */
	public Object[] getCharact() {
		Object[] charactArray = {this.color, this.shape, this.isFull};
		return charactArray;
	}
	
	/**
	 * Creates a deck of cards.
	 * @param withoutComponents an empty LinkedList without any card components
	 */
	static void createDeckComp(LinkedList<Card> withoutComponents) throws DeckAlreadyUsedException {
		if (!withoutComponents.isEmpty()) {
			throw new DeckAlreadyUsedException("Some card components already exists in the Deck.");
		} else {
			List<Integer> randIdList = Card.generateRandId(Deck.NUM_OF_CARDS); //Generates a List of card id in a random order
			Color[] cArr = Color.values(); //Retrieves all the elements of Color enum
			Shape[] sArr = Shape.values(); //Retrieves all the elements of Shape enum
			Boolean[] fArr = {false, true};
			int k=0; //To avoid deleting all the elements at once, I use an ArrayList, not a LinkedList
			for (int c=0;c<cArr.length;c++) {
				for (int s=0;s<sArr.length;s++) {
					for (int f=0;f<2;f++) {
						withoutComponents.add(new Card(randIdList.get(k), cArr[c], sArr[s], fArr[f])); //Create and insert a Card instance in the List
						k++;
					}
				}
			}
		}
		//then the garbage collector will delete randIdList
	}
	
	/**Generates a list of ids in a random order.
	 * 
	 * @param numbreId The number of id to create in a random order
	 * @return List a list of shuffled id
	 */
	public static List<Integer> generateRandId(int numbreId) {
		List<Integer> idList = new ArrayList<>();
		for (int i=1;i<=numbreId;i++) {
			idList.add(i);
		}
		Collections.shuffle(idList);
		return idList;
	}
	
	/**
	 * Prints card characteristics.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.color.name().charAt(0));
		sb.append(this.shape.name().charAt(0));
		if(this.isFull = false) {
			sb.append("E-"); //Empty
		} else {
			sb.append("F-"); //Full
		}
		sb.append(this.idCard);
		return sb.toString();
	}
	
	/**
	 * The main method.
	 * @param args
	 */
	public static void main(String[] args) {
		Card card1 = new Card(1,Color.RED,Shape.CIRCLE,true);
		System.out.println("Affichage Carte: "+card1.toString());
	}
	
}

