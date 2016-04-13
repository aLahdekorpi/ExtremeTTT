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
 * Test class for TwoPlayerGame
 * @author lalex
 */
public class TwoPlayerGameTest {

    private TwoPlayerGame game;
    private Cell[][] cells;

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
        if(
            this.cells[0][0].getToken() == ' ' ||
            this.cells[0][1].getToken() == ' ' ||
            this.cells[0][2].getToken() == ' ' ||
            this.cells[1][0].getToken() == ' ' ||
            this.cells[1][1].getToken() == ' ' ||
            this.cells[1][2].getToken() == ' ' ||
            this.cells[2][0].getToken() == ' ' ||
            this.cells[2][1].getToken() == ' ' ||
            this.cells[2][2].getToken() == ' '
                ){
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
    public void isFullFalseOneToken(){
        this.cells[0][0].setToken('O');
        assertFalse(game.isFull());
    }
    @Test
    public void isFullFalseEightTokens(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                this.cells[i][j].setToken('O');
            }
        }
        assertFalse(game.isFull());
    }
    
    
    @Test
    public void isWonRowsFalseWrongParameter(){
        assertFalse(game.isWonRows('B'));
        assertFalse(game.isWonRows('1'));
        assertFalse(game.isWonRows('!'));
        assertFalse(game.isWonRows(' '));
    }

    @Test
    public void isWonRowsTrueFirstRow() {
        this.cells[0][0].setToken('X');
        this.cells[0][1].setToken('X');
        this.cells[0][2].setToken('X');
        assertTrue(game.isWonRows('X'));
    }

    @Test
    public void isWonRowsTrueSecondRow() {
        this.cells[1][0].setToken('Y');
        this.cells[1][1].setToken('Y');
        this.cells[1][2].setToken('Y');
        assertTrue(game.isWonRows('Y'));
    }

    @Test
    public void isWonRowsTrueThirdRow() {
        this.cells[2][0].setToken('X');
        this.cells[2][1].setToken('X');
        this.cells[2][2].setToken('X');
        assertTrue(game.isWonRows('X'));
    }

    @Test
    public void isWonRowsFalseWithEmpty() {
        assertFalse(game.isWonRows('X'));
    }

    @Test
    public void isWonRowsFalseWithTwoPerRow() {
        this.cells[0][0].setToken('X');
        this.cells[0][1].setToken('X');
        this.cells[1][0].setToken('X');
        this.cells[1][1].setToken('X');
        this.cells[2][0].setToken('X');
        this.cells[2][1].setToken('X');
        assertFalse(game.isWonRows('X'));
    }

    @Test
    public void isWonRowsFalseWithOnePerRow() {
        this.cells[0][0].setToken('X');
        this.cells[1][0].setToken('X');
        this.cells[2][0].setToken('X');
        assertFalse(game.isWonRows('X'));
    }

    @Test
    public void isWonColumnsTrueFirstColumn() {
        this.cells[0][0].setToken('Y');
        this.cells[1][0].setToken('Y');
        this.cells[2][0].setToken('Y');
        assertTrue(game.isWonColumns('Y'));
    }

    @Test
    public void isWonColumnsTrueSecondColumn() {
        this.cells[0][1].setToken('X');
        this.cells[1][1].setToken('X');
        this.cells[2][1].setToken('X');
        assertTrue(game.isWonColumns('X'));
    }

    @Test
    public void isWonColumnsTrueThirdColumn() {
        this.cells[0][2].setToken('X');
        this.cells[1][2].setToken('X');
        this.cells[2][2].setToken('X');
        assertTrue(game.isWonColumns('X'));
    }

    @Test
    public void isWonColumnsFalseWhenEmpty() {
        assertFalse(game.isWonColumns('X'));
    }

    @Test
    public void isWonColumnsFalseTwoPerColumn() {
        this.cells[0][0].setToken('X');
        this.cells[1][0].setToken('X');
        this.cells[2][1].setToken('X');
        this.cells[0][1].setToken('X');
        this.cells[1][2].setToken('X');
        this.cells[2][2].setToken('X');
        assertFalse(game.isWonColumns('X'));
    }

    @Test
    public void isWonColumnsFalseOnePerColumn() {
        this.cells[0][0].setToken('X');
        this.cells[1][1].setToken('X');
        this.cells[0][2].setToken('X');
        assertFalse(game.isWonColumns('X'));
    }

    @Test
    public void isWonDiagonalFalseWhenEmpty() {
        assertFalse(game.isWonDiagonal('X'));
    }

    @Test
    public void isWonDiagonalTrueFromLeftUpToRightDown() {
        this.cells[0][0].setToken('X');
        this.cells[1][1].setToken('X');
        this.cells[2][2].setToken('X');
        assertTrue(game.isWonDiagonal('X'));
    }

    @Test
    public void isWonDiagonalTrueFromLeftDownToRightUp() {
        this.cells[0][2].setToken('X');
        this.cells[1][1].setToken('X');
        this.cells[2][0].setToken('X');
        assertTrue(game.isWonDiagonal('X'));
    }

    @Test
    public void isWonDiagonalFalseCornerAndMiddle() {
        this.cells[0][0].setToken('X');
        this.cells[1][1].setToken('X');
        this.cells[2][0].setToken('X');
        assertFalse(game.isWonDiagonal('X'));
    }

    @Test
    public void isWonFalseWhenAllFalse() {
        assertFalse(game.isWon());
    }

    @Test
    public void isWonTrueWhenRowsTrue() {
        this.cells[0][0].setToken('X');
        this.cells[0][1].setToken('X');
        this.cells[0][2].setToken('X');
        assertTrue(game.isWon());
    }

    @Test
    public void isWonTrueWhenColumnsTrue() {
        this.cells[1][0].setToken('Y');
        this.cells[2][0].setToken('Y');
        this.cells[0][0].setToken('Y');
        assertTrue(game.isWon());
    }

    @Test
    public void isWonTrueWhenDiagonalTrue() {
        this.cells[0][0].setToken('X');
        this.cells[1][1].setToken('X');
        this.cells[2][2].setToken('X');
        assertTrue(game.isWon());
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

        assertEquals('X', game.getWhoseTurn());
    }

    @Test
    public void swapTurnsWorksWhenX() {
        game.setWhoseTurn('X');
        game.swapTurns();
        assertEquals('Y', game.getWhoseTurn());
    }

    @Test
    public void swapTurnsWorksWhenY() {
        game.setWhoseTurn('Y');
        game.swapTurns();
        assertEquals('X', game.getWhoseTurn());

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
