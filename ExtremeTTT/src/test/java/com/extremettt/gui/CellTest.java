package com.extremettt.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CellTest {

    private Cell cell;

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
        cell = new Cell();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setterWorksWithWrongParameters() {
        cell.setToken('Y');
        cell.setToken(' ');
        cell.setToken('x');
        cell.setToken('y');
        cell.setToken('!');
        cell.setToken('5');
        assertEquals(cell.getToken(), 'Y');
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
