/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

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
public class WinCheckerTest {

    private TwoPlayerGame game;
    private WinChecker winC;

    public WinCheckerTest() {
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
        winC = new WinChecker(game);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void isWonRowsFalseWrongParameter() {
        assertFalse(winC.isWonRows('B'));
        assertFalse(winC.isWonRows('1'));
        assertFalse(winC.isWonRows('!'));
        assertFalse(winC.isWonRows(' '));
    }

    @Test
    public void isWonRowsTrueFirstRow() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[0][1].setToken('X');
        game.getCells()[0][2].setToken('X');
        assertTrue(winC.isWonRows('X'));
    }

    @Test
    public void isWonRowsTrueSecondRow() {
        game.getCells()[1][0].setToken('O');
        game.getCells()[1][1].setToken('O');
        game.getCells()[1][2].setToken('O');
        assertTrue(winC.isWonRows('O'));
    }

    @Test
    public void isWonRowsTrueThirdRow() {
        game.getCells()[2][0].setToken('X');
        game.getCells()[2][1].setToken('X');
        game.getCells()[2][2].setToken('X');
        assertTrue(winC.isWonRows('X'));
    }

    @Test
    public void isWonRowsFalseWithEmpty() {
        assertFalse(winC.isWonRows('X'));
    }

    @Test
    public void isWonRowsFalseWithTwoPerRow() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[0][1].setToken('X');
        game.getCells()[1][0].setToken('X');
        game.getCells()[1][1].setToken('X');
        game.getCells()[2][0].setToken('X');
        game.getCells()[2][1].setToken('X');
        assertFalse(winC.isWonRows('X'));
    }

    @Test
    public void isWonRowsFalseWithOnePerRow() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[1][0].setToken('X');
        game.getCells()[2][0].setToken('X');
        assertFalse(winC.isWonRows('X'));
    }

    @Test
    public void isWonColumnsTrueFirstColumn() {
        game.getCells()[0][0].setToken('O');
        game.getCells()[1][0].setToken('O');
        game.getCells()[2][0].setToken('O');
        assertTrue(winC.isWonColumns('O'));
    }

    @Test
    public void isWonColumnsTrueSecondColumn() {
        game.getCells()[0][1].setToken('X');
        game.getCells()[1][1].setToken('X');
        game.getCells()[2][1].setToken('X');
        assertTrue(winC.isWonColumns('X'));
    }

    @Test
    public void isWonColumnsTrueThirdColumn() {
        game.getCells()[0][2].setToken('X');
        game.getCells()[1][2].setToken('X');
        game.getCells()[2][2].setToken('X');
        assertTrue(winC.isWonColumns('X'));
    }

    @Test
    public void isWonColumnsFalseWhenEmpty() {
        assertFalse(winC.isWonColumns('X'));
    }

    @Test
    public void isWonColumnsFalseTwoPerColumn() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[1][0].setToken('X');
        game.getCells()[2][1].setToken('X');
        game.getCells()[0][1].setToken('X');
        game.getCells()[1][2].setToken('X');
        game.getCells()[2][2].setToken('X');
        assertFalse(winC.isWonColumns('X'));
    }

    @Test
    public void isWonColumnsFalseOnePerColumn() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[1][1].setToken('X');
        game.getCells()[0][2].setToken('X');
        assertFalse(winC.isWonColumns('X'));
    }

    @Test
    public void isWonDiagonalFalseWhenEmpty() {
        assertFalse(winC.isWonDiagonal('X'));
    }

    @Test
    public void isWonDiagonalTrueFromLeftUpToRightDown() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[1][1].setToken('X');
        game.getCells()[2][2].setToken('X');
        assertTrue(winC.isWonDiagonal('X'));
    }

    @Test
    public void isWonDiagonalTrueFromLeftDownToRightUp() {
        game.getCells()[0][2].setToken('X');
        game.getCells()[1][1].setToken('X');
        game.getCells()[2][0].setToken('X');
        assertTrue(winC.isWonDiagonal('X'));
    }

    @Test
    public void isWonDiagonalFalseCornerAndMiddle() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[1][1].setToken('X');
        game.getCells()[2][0].setToken('X');
        assertFalse(winC.isWonDiagonal('X'));
    }

    @Test
    public void isWonFalseWhenAllFalse() {
        assertFalse(winC.isWon());
    }

    @Test
    public void isWonTrueWhenRowsTrue() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[0][1].setToken('X');
        game.getCells()[0][2].setToken('X');
        assertTrue(winC.isWon());
    }

    @Test
    public void isWonTrueWhenColumnsTrue() {
        game.getCells()[1][0].setToken('O');
        game.getCells()[2][0].setToken('O');
        game.getCells()[0][0].setToken('O');
        assertTrue(winC.isWon());
    }

    @Test
    public void isWonTrueWhenDiagonalTrue() {
        game.getCells()[0][0].setToken('X');
        game.getCells()[1][1].setToken('X');
        game.getCells()[2][2].setToken('X');
        assertTrue(winC.isWon());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
