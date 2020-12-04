/**
 * 
 */
package gameEngine;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import gameEngine.enumerate.NumOfPlayers;



/**
 * @author Julien Coursimault
 *
 */
class PhysicalPlayer extends Player {
	
	private Map<Card, Integer[]> map = new HashMap<Card, Integer[]>();

	
	PhysicalPlayer(String name) {
		super(name);
	}

	@Override
	public Map<Card, Integer[]> play(Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner, GameBoard gBoard) {
		
	    Integer[] position = new Integer[2];
		takeCard(drawedCard);
		
		while(true){
		    try{
		    	System.out.println("Entrez la coordonnée en x : ");
				position[0] = Integer.parseInt(scanner.next());  // Read user input
		        break;
		    }catch(NumberFormatException e){
		        System.out.println("Mauvaise valeure. Entrez-en une nouvelle");
		    }
		}
		
		while(true){
		    try{
		    	System.out.println("Entrez la coordonnée en y : ");
				position[1] = Integer.parseInt(scanner.next());  // Read user input
		        break;
		    }catch(NumberFormatException e){
		        System.out.println("Mauvaise valeure. Entrez-en une nouvelle");
		    }
		}		
	    
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
	System.out.println("Mauvaise entr�e, recommencez");
	break;
}
}
i=0;*/