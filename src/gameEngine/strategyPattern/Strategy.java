/**
 * 
 */
package gameEngine.strategyPattern;

import java.util.Map;
import java.util.Scanner;

import gameEngine.Card;
import gameEngine.GameBoard;
import gameEngine.Player;
import gameEngine.VirtualPlayer;

/**
 * @author ludov
 *
 */
interface Strategy {
	public Map<Card, Integer[]> play(Player p1, Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner, GameBoard gBoard);
}
