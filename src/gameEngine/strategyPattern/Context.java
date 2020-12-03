/**
 * 
 */
package gameEngine.strategyPattern;

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
	
	/**
	 * Executes the current strategy.
	 */
	public void executeStrategy(Player p1, GameBoard gb) {
		strategy.play(p1, gb);
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
