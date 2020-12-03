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

/**
 * @author Marquès Ludovic
 * @version 1.0
 */
public class Context {
	
	/**
	 * Sets the default strategy.
	 */
	private Strategy strategy = new ConcreteDefaultStrategy();
	private Map<Card, Integer[]> map = new HashMap<Card, Integer[]>();

	
	/**
	 * Executes the current strategy.
	 */
	public Map<Card, Integer[]> executeStrategy(Player p1, Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner, GameBoard gBoard) {
		map=strategy.play(p1, drawedCard, mapCard, scanner, gBoard);
		return map;
	}
	
	/**
	 * Sets a new strategy.
	 * @param Strategy
	 */
	public void setStrategy(Strategy str) {
		this.strategy = str;
	}
	
	/**
	 * Returns the current strategy.
	 * @return Strategy
	 */
	public Strategy getStrategy() {
		return strategy;
	}
}
