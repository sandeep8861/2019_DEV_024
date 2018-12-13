package com.bnpp.interview.tenniskata.main;

import java.util.Scanner;

public class RunTennisGame {
	
	/*static{
		 Scanner readData = new Scanner(System.in);   
		 System.out.println("Enter Game Fixtures in this format :<Player1Name Player2Name Player1Score Player2Score>");
		 String str = readData.nextLine();
		 String [] str1 = str.split(",");
		 RunTennisGame.main(str1);
		}*/

	public static void main(String[] args) {
		
		Player player1=new Player(args[0]);
		Player player2=new Player(args[1]);
		
		player1.setScore(Integer.valueOf(args[2]));
		player2.setScore(Integer.valueOf(args[3]));
		
		TennisGame tennisGameFixture=new TennisGame(player1, player2);
		
		System.out.println("Leading Player :"+tennisGameFixture.getLeadPlayer().getName());
		System.out.println("Game Score is :"+tennisGameFixture.getScore());
	
	}

}
