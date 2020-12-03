/**
 * 
 */
package gameEngine;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;



/**
 * @author Julien Coursimault
 *
 */
class PhysicalPlayer extends Player {
	
	PhysicalPlayer(String name) {
		super(name);
	}

	@Override
	public Map<Card, Integer[]> play(Card drawedCard, Map<Card, Integer[]> mapCard, Scanner scanner) {
		
	    Integer[] position = new Integer[2];

		takeCard(drawedCard);
		System.out.println("Enter x coordonate : ");
	    position[0] = scanner.nextInt();  // Read user input
	    System.out.println("Enter y coordonate : ");
	    position[1] = scanner.nextInt();  // Read user input
	    
	    mapCard.put(giveCard(drawedCard), position);
	    
		return mapCard;
		
		}	
}
