/**
 * 
 */
package gameEngine;

import java.util.List;
import java.util.ArrayList;

/**
 * @author ludov
 *
 */
public abstract class GameBoard {
	protected String name;
	protected int width;
	protected int length;
	protected List<Boolean[]> activePos;
	protected List<Card[]> cardPos;
	
	public Card pickUpCard(Integer[] pos) {
		return null;
		
	}
	
	public boolean putDownCard(Integer[] pos) {
		return false;
		
	}
	
	protected boolean checkBorder(Integer[] pos) {
		return false;
		
	}
	
	protected boolean checkPos() {
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
