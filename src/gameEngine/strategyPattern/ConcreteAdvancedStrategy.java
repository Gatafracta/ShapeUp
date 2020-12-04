/**
 * 
 */
package gameEngine.strategyPattern;

import java.util.Map;
import java.util.Scanner;

import gameEngine.Card;
import gameEngine.GameBoard;
import gameEngine.Player;

/**
 * @author ludov
 *
 */
class ConcreteAdvancedStrategy implements Strategy {

	@Override
	public Map<Card, Integer[]> play(Player p1, Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner, GameBoard gBoard) {
		// TODO Auto-generated method stub 
		return mapCard; // -- doesn't work, this is only to prevent Eclipse to show problems
	}
	
}
