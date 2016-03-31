/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremett.logic;

import com.extremettt.logic.SinglePlayerGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lalex
 */
public class SinglePlayerGameTest {

    SinglePlayerGame game;

    public SinglePlayerGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new SinglePlayerGame();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void whoseTurnIsCorrectAtStart() {
        assertEquals(game.getWhoseTurn(), 'X');
    }

    @Test
    public void setterWorksWithY() {
        game.setWhoseTurn('Y');
        assertEquals(game.getWhoseTurn(), 'Y');
    }

    @Test
    public void setterWorksWithX() {
        game.setWhoseTurn('X');
        assertEquals(game.getWhoseTurn(), 'X');
    }

    @Test
    public void setterWorksWithRandomChars() {
        game.setWhoseTurn('A');
        game.setWhoseTurn('y');
        game.setWhoseTurn('x');
        game.setWhoseTurn('4');
        game.setWhoseTurn('!');
        game.setWhoseTurn(' ');

        assertEquals(game.getWhoseTurn(), 'X');
    }

    @Test
    public void swapTurnsWorksWhenX() {
        game.setWhoseTurn('X');
        game.swapTurns();
        assertEquals(game.getWhoseTurn(), 'Y');
    }

    @Test
    public void swapTurnsWorksWhenY() {
        game.setWhoseTurn('Y');
        game.swapTurns();
        assertEquals(game.getWhoseTurn(), 'X');

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
