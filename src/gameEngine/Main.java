package gameEngine;

import java.util.ArrayList;
import java.util.Scanner;

import org.fusesource.jansi.AnsiConsole;

import gameEngine.scoreVisitorPattern.*;
import gameEngine.enumerate.*;

public class Main {

	private static int i=0;
	private static int nbPlayer=0;
	private static int nbVirtalPlayer=0;
	private static int nbPhysicalPlayer=0;
	private static String nameOfPlayer;
	private static GameMode gMode = GameMode.DEFAULT;
	private static GameBoardEnum gBo = GameBoardEnum.RECTANGLE;
	private static NumOfPlayers nP = NumOfPlayers.TWO;
	private static GameBoard gB;
	private static Scanner mainscan = new Scanner(System.in);

	
	public static void main(String[] args) {

		System.out.println("Choisisser le type de plateau : ");
		System.out.println("Type de plateau disponnibles : rectangulaire (r)");
		
		while (i != 1) {
			switch (mainscan.next()) {
			case "r":
				gBo = GameBoardEnum.RECTANGLE;
				gB = new GameBoardRect(); 
				i = 1;
				break;

			default:
				System.out.println("Mauvaise entrée, recommencez");
				break;
			}	
		}
	    i = 0;
	    
	    System.out.println("Choissez le nombre de joueurs (2-3)");
	    
	    while (i != 1) {
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
	    i=0;

	    System.out.println("Combiens de joueurs virtuels souhaitez-vous ? (0-"+nbPlayer+")");
	    
	    while ( i != 1) {
		    switch (mainscan.next()) {
			case "0":
				nbVirtalPlayer = 0;
				i = 1;
				break;
			case "1":
				nbVirtalPlayer = 1;
				i = 1;
				break;
			case "2":
				nbVirtalPlayer = 2;
				i = 1;
				break;
			case "3":
				if (nbPlayer == 3) {
				nbVirtalPlayer = 3;
				i = 1;
				} else {
					System.out.println("Mauvaise entrée, recommencez");
				}
				break;
			default:
				System.out.println("Mauvaise entrée, recommencez");
				break;
			} 
	    }
	    
	    i=0;
	    
	    System.out.println("Choissez le type de variante");
	    System.out.println("Variantes disponnibles : classique (c)");
	    
	    while(i != 1) {
		    switch (mainscan.next()) {
			case "c":
				gMode = GameMode.DEFAULT;
				i=1;
				break;
		
			default:
				System.out.println("Mauvaise entrée, recommencez");
				break;
			}	    
	    }
	
	    
			
	GameSession session = new GameSession(gB, gMode, nP, nbPhysicalPlayer, nbVirtalPlayer, nbPlayer);
	
	

	}

}
