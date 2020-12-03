/**
 * 
 */
package gameEngine;

import gameEngine.enumerate.Color;
import gameEngine.enumerate.Shape;

import java.util.List;
import java.util.ArrayList;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import exceptions.*;

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
	
	public abstract void initActivePos();
	
	/**
	 * Returns and removes a card from the game board. If the position refers to nothing, it returns null.
	 * @param pos the position of the card
	 * @return Card
	 */
	public Card pickUpCard(Integer[] pos) {
		if (this.isPosition(pos)&&this.checkBorder(pos)&&!this.isAvailablePos(pos)) {
			Card cd = cardPos.get(pos[0])[pos[1]];
			cardPos.get(pos[0])[pos[1]]=null;
			return cd;
		} else {
			System.out.print("Pas de carte en "+pos);
			return null;
		}
	}
	
	public boolean putDownCard(Integer[] pos, Card card) {
		if (this.check(pos)) {
			this.cardPos.get(pos[0])[pos[1]] = card;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns true if the parameter is a position, in the border and the location is available.
	 * If this is not the case, returns false.
	 * @param pos the position
	 * @return boolean
	 */
	public boolean check(Integer[] pos) {
		if (this.isPosition(pos)&&this.checkBorder(pos)) {
			if (this.isAvailablePos(pos)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Returns true if the parameter is a position.
	 * @param pos the position
	 * @return boolean
	 */
	private boolean isPosition(Integer[] pos) {
		if (pos.length==2) {
			return true;
		} else {
			System.out.println(pos.toString()+" is not a position.");
			return false;
		}
	}
	
	/**
	 * Checks if the position is within the borders and returns true if so, otherwise returns false.
	 * @return boolean
	 */
	private boolean checkBorder(Integer[] pos) {
		if (pos[0]<width || pos[1]<length || 0<=pos[0] || 0<=pos[1]) {
			return true;
		} else {
			System.out.println(pos+" is out of borders.");
			return false;
		}
	}
	
	/**
	 * Returns true if the position is available, otherwise returns false.
	 * @param pos the position
	 * @return boolean
	 */
	private boolean isAvailablePos(Integer[] pos) {
		if (this.cardPos.get(pos[0])[pos[1]]==null) {
			return true;
		} else {
			System.out.println(pos+" is an unavailable position.");
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Returns the active positions on the game board.
	 * @return String
	 */
	public String activePosToString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ACTIVE POSITIONS:\n+");
		for (int k=0;k<length*3;k++) {
			sb.append('-');
		}
		sb.append("+\n");
		for (int i=0;i<width;i++) {
			sb.append("¦ ");
			for (int j=0;j<length;j++) {
				if (j==0) {
					sb.append(boolToString(this.activePos.get(i)[0]));
					}
				else {
					sb.append(" ");
					sb.append(boolToString(this.activePos.get(i)[j]));
					}
			}
			sb.append("  ¦\n");
		}
		sb.append('+');
		for (int k=0;k<length*3;k++) {
			sb.append('-');
		}
		sb.append('+');
		return sb.toString();
	}
	
	/**
	 * Returns a symbol depending on the Boolean in parameter.
	 * @param bool Boolean
	 * @return String
	 */
	private static String boolToString(Boolean bool) {
		if (bool==true) {
			return "✔";
		} else {
			return "✖";
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getLenght() {
		return length;
	}
	
	/**Prints the symbol related to the card.
	 * 
	 * @param card the card to print
	 * @return String
	 */
	public String cardToString(Card card) {
		StringBuffer sb = new StringBuffer();
		String[] sym = {"■","☻","▲","◘","☺","^"};
		try {
			Color c = (Color) card.getCharact()[0];
			Shape s = (Shape) card.getCharact()[1];
			boolean f = (boolean) card.getCharact()[2];
			
			AnsiConsole.systemInstall();
			switch (c) {
			case RED:
				if (f==true) sb.append(Ansi.ansi().fgRed().a(sym[s.ordinal()]).reset());
				else sb.append(Ansi.ansi().fgRed().a(sym[s.ordinal()+3]).reset());
				break;
			case GREEN:
				if (f==true) sb.append(Ansi.ansi().fgGreen().a(sym[s.ordinal()]).reset());
				else sb.append(Ansi.ansi().fgGreen().a(sym[s.ordinal()+3]).reset());
				break;
			case BLUE:
				if (f==true) sb.append(Ansi.ansi().fgBlue().a(sym[s.ordinal()]).reset());
				else sb.append(Ansi.ansi().fgBlue().a(sym[s.ordinal()+3]).reset());
				break;
			}
			//AnsiConsole.systemUninstall();
			return sb.toString();
		} catch (NullPointerException e) {
			sb.append(' ');
			return sb.toString();
		}
	}

}
