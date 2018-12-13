package com.bnpp.interview.tenniskata.main;

public class RunTennisGame {

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
