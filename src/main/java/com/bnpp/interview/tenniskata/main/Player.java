package com.bnpp.interview.tenniskata.main;

import java.util.Arrays;
import java.util.List;

public class Player {

	public static final List<String> pointsDescription = Arrays.asList("love", "fifteen", "thirty", "forty");

    private int score;
    public int getScore() {
        return score;
    }
    String name;
    public String getName() {
        return name;
    }

    public void winBall() {
        this.score = this.score + 1;
    }

    public Player(String name) {
        this.name = name;
        
    }
    public void setScore(int score){
    	this.score=score;
    }

    public String getScoreDescription(){
        return pointsDescription.get(score);
    }
}
