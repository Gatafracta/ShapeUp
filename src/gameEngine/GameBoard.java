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
