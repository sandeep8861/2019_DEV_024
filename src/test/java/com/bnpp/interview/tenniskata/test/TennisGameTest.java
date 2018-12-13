package com.bnpp.interview.tenniskata.test;

import org.junit.Before;
import org.junit.Test;

import com.bnpp.interview.tenniskata.main.Player;
import com.bnpp.interview.tenniskata.main.TennisGame;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
**Rules:**
* Scores from zero to three points are described as "love", "fifteen", "thirty", and "forty" respectively.
* If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "advantage" for the player in the lead.
* If at least three points have been scored by each player, and the scores are equal, the score is "deuce".
* A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
*/
public class TennisGameTest {

    Player victor;
    Player sarah;
    TennisGame game;

    @Before
    public void beforeGameTest() {
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        game = new TennisGame(victor, sarah);
    }

    @Test
    public void loveShouldBeDescriptionForScore0() {
    	TennisGame game = new TennisGame(victor, sarah);
        assertThat(game, hasProperty("score", is("love, love")));
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        sarah.winBall();
        assertThat(game, hasProperty("score", is("love, fifteen")));
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        victor.winBall();
        victor.winBall();
        sarah.winBall();
        assertThat(game, hasProperty("score", is("thirty, fifteen")));
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
                victor.winBall();
        });
        assertThat(game, hasProperty("score", is("forty, love")));
    }

    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            sarah.winBall();
        });
        assertThat(game, hasProperty("score", is("advantage Sarah")));
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winBall();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            sarah.winBall();
        });
        assertThat(game, hasProperty("score", is("deuce")));
        victor.winBall();
        assertThat(game, hasProperty("score", is(not("deuce"))));
        sarah.winBall();
        assertThat(game, hasProperty("score", is("deuce")));
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            victor.winBall();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            sarah.winBall();
        });
        assertThat(game, hasProperty("score", is(not("Victor won"))));
        assertThat(game, hasProperty("score", is(not("Sarah won"))));
        victor.winBall();
        assertThat(game, hasProperty("score", is("Victor won")));
    }

}