/**
 * 
 */
package gameEngine.strategyPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import gameEngine.Card;
import gameEngine.GameBoard;
import gameEngine.Player;
import gameEngine.VirtualPlayer;
import gameEngine.scoreVisitorPattern.GameBoardRect;

/**
 * @author ludov
 *
 */

class ConcreteDefaultStrategy implements Strategy {
	
	private Map<Card, Integer[]> map = new HashMap<Card, Integer[]>();
	public static int i=0;

	@Override
	public Map<Card, Integer[]> play(Player p1, Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner, GameBoard gBoard) {
		
	    Integer[] position = new Integer[2];
		p1.takeCard(drawedCard);
		while (i!=1) {
			position[1] = (int) Math.round(Math.random()*((gBoard.getLenght()-1)));
			position[0] = (int) Math.round(Math.random()*((gBoard.getWidth()-1)));
			if (gBoard.check(position)) {
				map.put(p1.giveCard(drawedCard), position);
				i = 1;
			}
		}
				
		return map;
		
	}
	
	//public void putCard() {}
	
	//public void takeCard() {}
}
