/**
 * 
 */
package gameEngine;
import gameEngine.strategyPattern.*;
import java.util.Map;
import java.util.Scanner;

import com.sun.tools.javac.util.Context;

/**
 * @author ludov
 *
 */

public class VirtualPlayer extends Player {

	private Context context = new Context();

	public VirtualPlayer(String name) {
		super(name);
	}

	@Override
	public Map<Card, Integer[]> play(Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner, GameBoard gBoard) {
		
		context.executeStrategy(this, gBoard);
		
	}

}
