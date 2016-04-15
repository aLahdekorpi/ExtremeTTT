/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.domain;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for class Start
 * @author lalex
 */
public class StartTest {
    private final ByteArrayOutputStream outPut = new ByteArrayOutputStream();
    Start start;
    public StartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outPut));
        start = new Start();
    }
    
    @After
    public void tearDown() {
        System.setOut(null);
    }
    
    @Test
    public void startGameWorksWithS() {
        start.startGame("S");
        assertEquals("Single decided", outPut.toString());
    }

    @Test
    public void startGameWorksWithT() {
        start.startGame("T");
        assertEquals("Two decided", outPut.toString());
    }

    @Test
    public void startGameDoesntWorkWithEmpty() {
        start.startGame("");
        assertEquals("Problem in parameter", outPut.toString());
    }

    @Test
    public void startGameDoesntWorkWithRandomString() {
        start.startGame("Random String");
        assertEquals("Problem in parameter", outPut.toString());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
