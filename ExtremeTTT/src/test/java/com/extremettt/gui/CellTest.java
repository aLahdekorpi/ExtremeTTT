package com.extremettt.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.extremettt.gui.Cell;
import com.extremettt.logic.TwoPlayerGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for class Cell.
 *
 * @author lalex
 */
public class CellTest {

    private Cell cell;
    private TwoPlayerGame game;

    public CellTest() {
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
        cell = new Cell(game);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setterWorksWithWrongParameters() {
        cell.setToken('O');
        cell.setToken(' ');
        cell.setToken('x');
        cell.setToken('o');
        cell.setToken('!');
        cell.setToken('5');
        assertEquals(cell.getToken(), 'O');

    }

    @Test
    public void setterWorksWithRightParameter() {
        cell.setToken('X');
        cell.setToken('x');
        cell.setToken('o');
        cell.setToken('!');
        assertEquals(cell.getToken(), 'X');
    }

    @Test
    public void setterWorksIfTokenAlready() {
        cell.setToken('X');
        cell.setToken('O');
        cell.setToken('O');
        cell.setToken(' ');
        assertEquals(cell.getToken(), 'X');
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
