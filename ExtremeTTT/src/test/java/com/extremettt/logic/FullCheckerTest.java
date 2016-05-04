/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author lalex
 */
public class FullCheckerTest {
    TwoPlayerGame game;
    FullChecker fullC;
    public FullCheckerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.game = new TwoPlayerGame();
        this.fullC = new FullChecker(this.game);
    }
    
    @After
    public void tearDown() {
    }
        @Test
    public void isFullTrueWhenFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.game.getCells()[i][j].setToken('X');
            }
        }
        if (this.game.getCells()[0][0].getToken() == ' '
                || this.game.getCells()[0][1].getToken() == ' '
                || this.game.getCells()[0][2].getToken() == ' '
                || this.game.getCells()[1][0].getToken() == ' '
                || this.game.getCells()[1][1].getToken() == ' '
                || this.game.getCells()[1][2].getToken() == ' '
                || this.game.getCells()[2][0].getToken() == ' '
                || this.game.getCells()[2][1].getToken() == ' '
                || this.game.getCells()[2][2].getToken() == ' ') {
            fail();
        }
        assertTrue(this.fullC.isFull());
    }

    @Test
    public void isFullFalseWhenEmpty() {
        assertFalse(this.fullC.isFull());
    }

    @Test
    public void isFullWorksFalseThreeTokens() {
        this.game.getCells()[0][0].setToken('X');
        this.game.getCells()[0][1].setToken('O');
        this.game.getCells()[0][2].setToken('X');
        assertFalse(this.fullC.isFull());
    }

    @Test
    public void isFullFalseOneToken() {
        this.game.getCells()[0][0].setToken('O');
        assertFalse(this.fullC.isFull());
    }

    @Test
    public void isFullFalseEightTokens() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                this.game.getCells()[i][j].setToken('O');
            }
        }
        assertFalse(this.fullC.isFull());
    }



    @Test
    public void isFullFalseWhenWrongParameter() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.game.getCells()[i][j].setToken('K');
            }
        }
        assertFalse(this.fullC.isFull());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
