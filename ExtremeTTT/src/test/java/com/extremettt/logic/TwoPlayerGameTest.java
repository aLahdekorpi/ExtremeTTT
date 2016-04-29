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
    public void isFullTrueWhenFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j].setToken('X');
            }
        }
        if (this.cells[0][0].getToken() == ' '
                || this.cells[0][1].getToken() == ' '
                || this.cells[0][2].getToken() == ' '
                || this.cells[1][0].getToken() == ' '
                || this.cells[1][1].getToken() == ' '
                || this.cells[1][2].getToken() == ' '
                || this.cells[2][0].getToken() == ' '
                || this.cells[2][1].getToken() == ' '
                || this.cells[2][2].getToken() == ' ') {
            fail();
        }
        assertTrue(game.isFull());
    }

    @Test
    public void isFullFalseWhenEmpty() {
        assertFalse(game.isFull());
    }

    @Test
    public void isFullWorksFalseThreeTokens() {
        this.cells[0][0].setToken('X');
        this.cells[0][1].setToken('O');
        this.cells[0][2].setToken('X');
        assertFalse(game.isFull());
    }

    @Test
    public void isFullFalseOneToken() {
        this.cells[0][0].setToken('O');
        assertFalse(game.isFull());
    }

    @Test
    public void isFullFalseEightTokens() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                this.cells[i][j].setToken('O');
            }
        }
        assertFalse(game.isFull());
    }



    @Test
    public void isFullFalseWhenWrongParameter() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j].setToken('K');
            }
        }
        assertFalse(game.isFull());
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
