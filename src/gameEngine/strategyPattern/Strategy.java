/**
 * 
 */
package gameEngine.strategyPattern;

import gameEngine.GameBoard;
import gameEngine.Player;
import gameEngine.VirtualPlayer;

/**
 * @author ludov
 *
 */
interface Strategy {
	public void play(Player p1, GameBoard gb);
}
