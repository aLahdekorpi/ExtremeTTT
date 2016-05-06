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
public class BoardSweeperTest {
    private TwoPlayerGame game;
    private BoardSweeper sweeper;
    public BoardSweeperTest() {
        
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
        this.sweeper = new BoardSweeper(this.game);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void nullifyGameBoardNullsFullBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.game.getCells()[i][j].setToken('X');
            }
        }
        this.sweeper.nullifyGameBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(this.game.getCells()[i][j].getToken(), ' ');
            }
        }
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
