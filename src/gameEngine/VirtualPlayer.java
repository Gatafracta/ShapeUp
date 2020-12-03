/**
 * 
 */
package gameEngine;
import gameEngine.strategyPattern.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import gameEngine.strategyPattern.*;

/**
 * @author ludov
 *
 */

public class VirtualPlayer extends Player {

	private Context context = new Context();
	private Map<Card, Integer[]> map = new HashMap<Card, Integer[]>();


	public VirtualPlayer(String name) {
		super(name);
	}

	@Override
	public Map<Card, Integer[]> play(Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner, GameBoard gBoard) {
		
		map = context.executeStrategy(this, drawedCard, mapCard, scanner, gBoard);
		return map;
		
	}

}
