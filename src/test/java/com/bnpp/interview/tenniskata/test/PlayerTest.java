package com.bnpp.interview.tenniskata.test;

import java.util.stream.IntStream;

import org.junit.Test;

import com.bnpp.interview.tenniskata.main.Player;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest {

    @Test
    public void pointsCanBeAddedToEachPlayer() {
        Player victor = new Player("Victor");
        Player sarah = new Player("Sarah");
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            sarah.winBall();
        });
        assertThat(victor, hasProperty("score", is(3)));
        assertThat(sarah, hasProperty("score", is(4)));
    }
}
