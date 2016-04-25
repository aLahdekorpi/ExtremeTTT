/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

import com.extremettt.gui.Cell;
import com.extremettt.gui.Frame;

/**
 * Class contains the logic for a singleplayer game.
 * @author lalex
 */
public class SinglePlayerGame extends TwoPlayerGame {

    private char whoseTurn = 'X';
    private Frame frame;
    private Cell[][] cells;
    private final char mode = 'S';
    /**
     * Constructor.
     */
    public SinglePlayerGame() {
        this.frame = new Frame(SinglePlayerGame.this);
        initializeGameFrame();
        this.cells = this.frame.getCells();

    }

    public char getMode() {
        return mode;
    }
    
}
