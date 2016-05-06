/*
 * To change this license header, choose License Headers in Project Properties.
 */
package com.extremettt.logic;

import com.extremettt.gui.Cell;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for class TwoPlayerGame.
 *
 * @author lalex
 */
public class TwoPlayerGameTest {

    private TwoPlayerGame game;
    private Cell[][] cells;
    private WinChecker winC;

    public TwoPlayerGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new TwoPlayerGame();
        cells = game.getFrame().getCells();
        winC = new WinChecker(game);
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
        game.setWhoseTurn('O');
        assertEquals(game.getWhoseTurn(), 'O');
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

        assertEquals('X', game.getWhoseTurn());
    }

    @Test
    public void swapTurnsWorksWhenX() {
        game.setWhoseTurn('X');
        game.swapTurns();
        assertEquals('O', game.getWhoseTurn());
    }

    @Test
    public void swapTurnsWorksWhenY() {
        game.setWhoseTurn('O');
        game.swapTurns();
        assertEquals('X', game.getWhoseTurn());

    }

    @Test
    public void addPointAddsOneToX() {
        game.setWhoseTurn('X');
        game.addPointToWinner();
        assertEquals(game.getWinsX(), 1);
    }

    @Test
    public void addPointAddsOneToO() {
        game.setWhoseTurn('O');
        game.addPointToWinner();
        assertEquals(game.getWinsO(), 1);
    }

    @Test
    public void addPointAddsOneToBoth() {
        game.setWhoseTurn('O');
        game.addPointToWinner();
        game.setWhoseTurn('X');
        game.addPointToWinner();
        assertEquals(game.getWinsO(), 1);
        assertEquals(game.getWinsX(), 1);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
