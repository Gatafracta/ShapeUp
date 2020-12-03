/**
 * 
 */
package gameEngine.scoreVisitorPattern;

import gameEngine.GameBoard;
import gameEngine.Card;

import java.util.ArrayList;

import gameEngine.enumerate.Color;
import gameEngine.enumerate.Shape;

/**
 * @author Marquès Ludovic
 *
 */
public class GameBoardRect extends GameBoard implements GameBoardCount {
	
	public static void main(String args[]) {		
		GameBoardRect gbr = new GameBoardRect();
		gbr.activePos.get(1)[4] = false;
		//System.out.println(gbr.activePos.get(0)[2]);
		
		System.out.println(gbr.activePosToString());
		
		//Remettre le Constructeur carte en private dès que possible
		/*gbr.cardPos.get(2)[6]=new Card(1, Color.RED, Shape.SQUARE, true);
		gbr.cardPos.get(1)[4]=new Card(2, Color.GREEN, Shape.CIRCLE, true);
		gbr.cardPos.get(0)[0]=new Card(3, Color.BLUE, Shape.TRIANGLE, true);
		gbr.cardPos.get(2)[5]=new Card(4, Color.RED, Shape.SQUARE, false);
		gbr.cardPos.get(2)[2]=new Card(5, Color.GREEN, Shape.CIRCLE, false);
		gbr.cardPos.get(1)[2]=new Card(6, Color.BLUE, Shape.TRIANGLE, false);*/
		System.out.println(gbr);
	}
	
	public GameBoardRect() {
		width=3;
		length=10;
		this.initActivePos();
		this.initCardPos();
	}
	
	/**
	 * Initializes the game board.
	 */
	public void initCardPos() {
		this.cardPos = new ArrayList<>();
		Card[] arr;
		for (int i=0;i<width;i++) {
			arr = new Card[length];
			for (int j=0;j<length;j++) {
				arr[j]=(Card) null;
			}
			cardPos.add(arr);
		}
	}
	
	/**
	 * Initializes the active positions.
	 */
	public void initActivePos() {
		this.activePos = new ArrayList<>();
		Boolean[] arr;
		for (int i=0;i<width;i++) {
			arr = new Boolean[length];
			for (int j=0;j<length;j++) {
				arr[j]=true;
			}
			activePos.add(arr);
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getLenght() {
		return length;
	}
	/**
	 * Prints the cards on the game board.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("CARD POSITIONS:\n+");
		for (int k=0;k<length*3;k++) {
			sb.append('-');
		}
		sb.append("+\n");
		for (int i=0;i<width;i++) {
			sb.append("¦ ");
			for (int j=0;j<length;j++) {
				if (j==0) {
					sb.append(this.cardToString(this.cardPos.get(i)[0]));
					}
				else {
					sb.append("  ");
					sb.append(this.cardToString(this.cardPos.get(i)[j]));
					}
			}
			sb.append(" ¦\n");
		}
		sb.append('+');
		for (int k=0;k<length*3;k++) {
			sb.append('-');
		}
		sb.append('+');
		return sb.toString();
	}
	
}
