/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.extremettt.start.Main.startGame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class MainTest {
    private final ByteArrayOutputStream outPut = new ByteArrayOutputStream();
    public MainTest() {
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
    }
    
    @After
    public void tearDown() {
        System.setOut(null);
    }
    @Test
    public void startGameWorksWithS(){
        startGame("S");
        assertEquals("Single decided", outPut.toString());
    }
    @Test
    public void startGameWorksWithT(){
        startGame("T");
        assertEquals("Two decided", outPut.toString());
    }
    @Test
    public void startGameDoesntWorkWithEmpty(){
        startGame("");
        assertEquals("Problem in parameter", outPut.toString());
    }
    @Test
    public void startGameDoesntWorkWithRandomString(){
        startGame("RandomString");
        assertEquals("Problem in parameter", outPut.toString());
    }
       


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
