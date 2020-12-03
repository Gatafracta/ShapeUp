/**
 * 
 */
package gameEngine.strategyPattern;

import gameEngine.GameBoard;
import gameEngine.Player;
import gameEngine.VirtualPlayer;
import gameEngine.scoreVisitorPattern.GameBoardRect;

/**
 * @author ludov
 *
 */
class ConcreteDefaultStrategy implements Strategy {
	
	public static void main(String[] args) {
		Player p1 = new VirtualPlayer("David");
		GameBoard gb1 = new GameBoardRect();
		
		Context cxt = new Context();
		cxt.executeStrategy(p1, gb1);
	}

	@Override
	public void play(Player p1, GameBoard gb) {
		//Prendre une carte du joueur.
		//Essayer des positions au hazard.
		//Poser la carte
	}
	
	//public void putCard() {}
	
	//public void takeCard() {}
}
