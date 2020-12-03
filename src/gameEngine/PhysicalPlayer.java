/**
 * 
 */
package gameEngine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import gameEngine.enumerate.NumOfPlayers;



/**
 * @author Julien Coursimault
 *
 */
class PhysicalPlayer extends Player {
	
	private Map<Card, Integer[]> map = new HashMap<Card, Integer[]>();
	private int i=0;
	
	PhysicalPlayer(String name) {
		super(name);
	}

	@Override
	public Map<Card, Integer[]> play(Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner, GameBoard gBoard) {
		
	    Integer[] position = new Integer[2];
		takeCard(drawedCard);
		System.out.println("Enter x coordonate : ");
	    position[0] = scanner.nextInt();  // Read user input
	    System.out.println("Enter y coordonate : ");
	    position[1] = scanner.nextInt();  // Read user input
	    
	    map.put(giveCard(drawedCard), position);
    
		return map;
		
		}	
}









/*while (i != 1) {
switch (mainscan.next()) {
case "2":
	nP = NumOfPlayers.TWO;
	i=1;
	nbPlayer = 2;
	break;

case "3":
	nP = NumOfPlayers.THREE;
	nbPlayer = 3;
	i=1;
	break;
	
default:
	System.out.println("Mauvaise entrée, recommencez");
	break;
}
}
i=0;*/